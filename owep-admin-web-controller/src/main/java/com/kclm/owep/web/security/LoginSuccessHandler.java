/**************************
 * xxx 公司版权所有，未经同意，不可以随意复制、转发
 */
package com.kclm.owep.web.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kclm.owep.utils.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/******************************************
 * 登录成功处理器
 *
 * @author yejf
 * @date 2023-11-27
 * @time 17:20
 * @package com.kclm.owep.web.security
 */
@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.debug("===> 登录成功");
        //后面也将通过jwt进行登录成功后的用户信息包装， 这里暂且返回成功信息
        Map<String,String> map = new HashMap<>();
        //
        map.put("message","登录成功");
        //生成jwt，并放置到请求头中
        User user = (User)authentication.getPrincipal();
        log.debug("===> 登录的用户名是："+user.getUsername());
        String jwt = JwtUtil.createToken(user.getUsername(), 15*60);
        log.debug("===> 生成的jwt是："+jwt);
        response.setHeader(JwtUtil.getHeader(), jwt);  //响应头名称：Authorization
        //
        response.setContentType("application/json;charset=UTF-8");
        //
        ObjectMapper objectMapper = new ObjectMapper();
        String resBody = objectMapper.writeValueAsString(map);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(resBody);
        printWriter.flush();
        printWriter.close();
    }
}
