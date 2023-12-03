/**************************
 * xxx 公司版权所有，未经同意，不可以随意复制、转发
 */
package com.kclm.owep.web.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/******************************************
 * 登录失败处理器
 *
 * @author yejf
 * @date 2023-11-27
 * @time 16:52
 * @package com.kclm.owep.web.security
 */
@Component
@Slf4j
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.debug("---> 登录失败，进入登录失败处理器=》原因："+exception.getMessage());
        System.out.println(exception);
        System.out.println(exception.getClass());
        HashMap<String, String> map = new HashMap<>(2);
        //后面才用JWT来封装错语信息，这里暂时采用 jackson-databind提供的方法返回json字符串
        if(exception instanceof InternalAuthenticationServiceException) {
            //帐户禁用
            map.put("message", exception.getMessage());
        } else {
            //用户名或密码不正确时，都是抛出 BadCredentialsException 异常
            map.put("message", "用户名或密码不正确");
        }
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
