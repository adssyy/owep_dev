/**************************
 * xxx 公司版权所有，未经同意，不可以随意复制、转发
 */
package com.kclm.owep.web.security;

import com.kclm.owep.dto.UserDto;
import com.kclm.owep.service.UserService;
import com.kclm.owep.utils.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/******************************************
 * Jwt认证过滤器
 *
 * @author yejf
 * @date 2023-11-28
 * @time 16:06
 * @package com.kclm.owep.web.security
 */
@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    //
    @Autowired
    private SpringDataUserDetailService userDetailsService;
    //
    @Autowired
    private UserService userService;

    /****
     * 重写父类构造
     * @param authenticationManager
     */
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        log.debug("---> 创建JwtAuthenticationFilter...,认证管理器是："+authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.debug("---> 请求进入JwtAuthenticationFilter中");
        //获取请求头
        String jwt = request.getHeader(JwtUtil.getHeader());
        //判断
        if(StringUtils.isEmpty(jwt)) {
            log.debug("---> jwt为null或empty");
            chain.doFilter(request,response); //如果配置了 AuthenticationEntryPoint,则会进入此类的commence方法中
            return;
        }
        // 没有返回，则说明存在jwt信息[客户端发过来的]
        JwtClaims claims = JwtUtil.parseToken(jwt);
        //判断是否为空
        if(StringUtils.isEmpty(claims)) {
            throw new RuntimeException("Token为Empty");
        }
        //判断是否过期
        if(!JwtUtil.isExpiration(claims)) {
            log.debug("jwt Token过期了");
            throw new RuntimeException("Token过期了");
        }
        //Token续签，以保证通过认证的请求可以自动延期有效时间
        String newToken = JwtUtil.renewalToken(claims);
        if(!StringUtils.isEmpty(newToken)) {
            System.out.println("===> 续签Token成功,新的Token是："+newToken);
            //表示续签成功
            response.setHeader(JwtUtil.getHeader(), newToken);
        }

        //获取用户名
        try {
            String username = claims.getSubject();
            //
            log.debug("---> 解析成功jwt,用户名是："+username);

            //调用业务层对象，根据用户名再来查询一次
            UserDto userDto = userService.selectByName(username);
            //判断
            if(userDto == null) {
                log.warn("--in JwtAuthenticationFilter:-->用户名不存在: {}", username);
                throw new UsernameNotFoundException("用户【"+username+"】不存在");
            }
            //判断用户的状态是否是禁用,其中，0表示禁用
            if(userDto.getUserStatus() == 0) {
                log.warn("--in JwtAuthenticationFilter:-->用户{}的状态已禁用",username);
                throw new LockedException("用户【"+username+"】的状态已禁用");
            }
            //再调用 UserDetailService来获权限
            List<GrantedAuthority> userAuthorities = userDetailsService.getUserAuthorities(userDto.getId());
            //构建Token
            UsernamePasswordAuthenticationToken token
                    = new UsernamePasswordAuthenticationToken(username, null, userAuthorities);
            //重新写入到SecurityContext中去
            SecurityContextHolder.getContext().setAuthentication(token);
            //放行
            chain.doFilter(request,response);
        } catch (MalformedClaimException e) {
            e.printStackTrace();
        }

    }
}
