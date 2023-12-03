package com.kclm.owep.web.config;

import com.kclm.owep.web.security.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启方法级授权访问
@EnableWebSecurity   //配置web层面的安全性
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] URL_WHITE_LIST = {
        "/login",
        "/logout",
        "/captcha",
        "/favicon.ico"
    };

    @Autowired
    private SpringDataUserDetailService userDetailService;

    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private JwtWebAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //日志
        log.debug("---> 在SecurityConfiguration类中的configure(AuthenticationManagerBuilder auth)方法中....");
        auth
                .userDetailsService(userDetailService)//用户信息服务
                .passwordEncoder(passwordEncoder());//使用自定义的编码器
    }

    @Override //安全拦截机制*
    protected void configure(HttpSecurity http) throws Exception {
        //
        log.debug("---> 在SecurityConfiguration类中的configure(HttpSecurity http)方法中....");

        //关闭csrf并且指定为无状态的会话管理
        http.csrf().disable()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //登录设置
        http
                .formLogin()    //采用表单登录，相当于使用 UsernameAndPasswordAuthenticationFilter
                .successHandler(loginSuccessHandler)   //指定登录成功处理器,只是针对UsernameAndPasswordAuthenticationFilter
                .failureHandler(loginFailureHandler);   //指定登录失败处理器,只是针对UsernameAndPasswordAuthenticationFilter
        //过滤请求url的配置
        http
                .authorizeRequests()
                .antMatchers(URL_WHITE_LIST).permitAll()
                .anyRequest().authenticated();
        //添加过滤器
        http.addFilter(jwtAuthenticationFilter());
        //在UsernamePasswordAuthenticationFilter之前添加JsonUsernamePasswordAuthenticationFilter
        http.addFilterBefore(jsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        //异常处理
        http
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)   //没有传正确的jwt信息过来/未登录 处理器
                .accessDeniedHandler(accessDeniedHandler);

        //开启跨域访问
        http
                .cors();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //
        log.debug("---> 在SecurityConfiguration类中的configure(WebSecurity web)方法中....");
        //
        web
                .ignoring().antMatchers("/static/**");
    }

    /************************
     * 密码加密器
     * @return
     */
    public PasswordEncoder passwordEncoder(){
        //TODO 暂时使用的是无加密编码器（直译）
        return NoOpPasswordEncoder.getInstance();
        // 如果要采用加密，则创建下面的密码加密器
        //return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager());
        log.debug("===> 创建jwtAuthenticationFilter对象:"+jwtAuthenticationFilter);
        //
        return jwtAuthenticationFilter;
    }

    /****
     * add by yejf
     * @return
     * @throws Exception
     */
    @Bean
    public JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter() throws Exception {
        JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter = new JsonUsernamePasswordAuthenticationFilter();
        //用set方法注入AuthenticationManager
        jsonUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
        //在这里也要指定登录成功和失败时的处理器
        jsonUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
        jsonUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(loginFailureHandler);
        //
        return jsonUsernamePasswordAuthenticationFilter;
    }
}
