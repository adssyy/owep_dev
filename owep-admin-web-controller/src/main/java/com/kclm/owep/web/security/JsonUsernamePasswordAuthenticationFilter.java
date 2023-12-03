/**************************
 * xxx 公司版权所有，未经同意，不可以随意复制、转发
 */
package com.kclm.owep.web.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/******************************************
 * 针对前后端分离的项目，前端传入的登录信息是采用json数据格式，而不是普通的表单数据。
 * 此情况下，默认的UsernamePasswordAuthenticationFilter的处理方式不能解析json数据，所以这里要扩展一下它的形为
 *
 * @author yejf
 * @date 2023-12-03
 * @time 15:49
 * @package com.kclm.owep.web.security
 */
@Slf4j
public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public JsonUsernamePasswordAuthenticationFilter() {
        super();
    }

    /*********************
     * 做验证时会先调用此方法，在此方法中获取请求参数，然后把请求参数封装成 UsernamePasswordAuthenticationToken
     * 再获取认证管理器的认证方法去认证
     * 我们这里的实现即要考虑json格式的数据，也可考虑普通的表单数据,如果是普通的表单数据，则调用父类的attemptAuthentication方法
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.debug("---> 进入JsonUsernamePasswordAuthenticationFilter的attemptAuthentication方法");
        //判断
        if(request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
            log.debug("---> 处理json格式的请求参数");
            //如果请求的类型是application/json的话，则进入json处理
            //1. 通过 jackson提供的ObjectMapper来解打
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map<String, String> map = objectMapper.readValue(request.getInputStream(), new TypeReference<Map<String, String>>() {
                });
                //获取用户名和密码
                String username = map.get(getUsernameParameter());
                String password = map.get(getPasswordParameter());
                log.debug("---> 解析出来的登录用户名是："+username);
                //所用户名和密码转换成 UsernamePasswordAuthenticationToken
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
                //调用认证管理器进行认证
                return getAuthenticationManager().authenticate(token);

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("处理登录时的json请求数据出错", e);
            }

        }
        return super.attemptAuthentication(request, response);
    }
}
