/**************************
 * xxx 公司版权所有，未经同意，不可以随意复制、转发
 */
package com.kclm.owep.web.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/******************************************
 * Jwt验证失败处理器
 *
 * @author yejf
 * @date 2023-11-29
 * @time 9:14
 * @package com.kclm.owep.web.security
 */
@Component
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.debug("---> 进入AuthenticationEntryPoint的commence方法:"+authException);
        //
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //提示 未认证
        //
        Map<String, String> map = new HashMap<>();
        System.out.println("===>"+authException.getMessage());
        map.put("msg","无Token信息或是Token已过期，请重新登录");
        map.put("uri", request.getRequestURI());
        //map.put("code",String.valueOf(HttpServletResponse.SC_UNAUTHORIZED));
        //利用ObjectMapper转换成json发送到前端
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(map);
        //
        PrintWriter writer = response.getWriter();
        writer.print(json);
        //
        writer.flush();
        writer.close();
    }
}
