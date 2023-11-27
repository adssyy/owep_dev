package com.kclm.owep.web.config;

import com.kclm.owep.web.security.SpringDataUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启方法级授权访问
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpringDataUserDetailService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //日志
        log.debug("---> 在SecurityConfiguration类中的configure(AuthenticationManagerBuilder auth)方法中....");
        auth
                .userDetailsService(userDetailService)//用户信息服务
                .passwordEncoder(passwordEncoder())//使用自定义的编码器
                ;
    }

    @Override //安全拦截机制*
    protected void configure(HttpSecurity http) throws Exception {
        //
        log.debug("---> 在SecurityConfiguration类中的configure(HttpSecurity http)方法中....");
        //自定义表单登录
       /* http
                .formLogin()
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successForwardUrl("/login")
                                //.loginProcessingUrl("/admin/login")
                                        .failureUrl("/login?error")
                                        .permitAll();

        //拦截器配置
        http
                .authorizeRequests()
                //.antMatchers("/login").permitAll()
                        .antMatchers("/admin/login").permitAll() //登录请求不需要验证
                        .antMatchers("/getMenu").permitAll()
                        .antMatchers("/privilege/**").authenticated()
                        .anyRequest().permitAll(); //其余请求放行【暂且】

        // 退出登录配置
        http
                .logout()
                        .logoutUrl("/admin/logout") //注销的路径
                        .clearAuthentication(true) //清除认证数据
                        .invalidateHttpSession(true);  //清除session
        //异常处理
        http
                .exceptionHandling()
                        //.authenticationEntryPoint(null)   //未登录 处理器
                        .accessDeniedHandler(new WebAccessDeniedHandler());
        //关闭csrf防护，取肖跨站请求伪造防护
        http
                .csrf().disable()
                        .headers().frameOptions().sameOrigin(); //允许同源头嵌套，此设置允许页面经由iframe框架嵌套到别处
        //开启跨域访问
                http
                .cors();*/
        //
        http
                .csrf().disable()
                .headers().frameOptions().sameOrigin()//允许同源头嵌套，此设置允许页面经由iframe框架嵌套到别处
                .and()
                .formLogin()//允许表单登录
                .loginPage("/login")//自定登陆页面
                .usernameParameter("username")//配置自定义界面
                .passwordParameter("password")
                .successForwardUrl("/login")
                .failureUrl("/login?error")//指定登录失败后跳转到/login?error页面
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .and()
                .authorizeRequests()//请求url权限过滤
//                .antMatchers("/static/**").permitAll()//放行对静态资源的请求
                .antMatchers("/user/*").authenticated()
                .antMatchers("/getMenu").permitAll()
//                .antMatchers("/privilege/**").authenticated()//在访问对应url时需要在security系统中已有身份(已登录)；具体的请求在controller中验证权限开放
                .anyRequest().permitAll()//对于剩余未作定义的默认为向所有访问公开
                .and()
                .exceptionHandling()//定义页面异常处理
                .accessDeniedHandler(new WebAccessDeniedHandler()); //访问拒绝异常处理

        //
        http.cors();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //
        log.debug("---> 在SecurityConfiguration类中的configure(WebSecurity web)方法中....");
        //
        web
                .ignoring().antMatchers("/static/**")
        ;
    }

    /************************
     * 密码加密器
     * @return
     */
    public PasswordEncoder passwordEncoder(){
        //TODO 暂时使用的是无加密编码器（直译）
        return NoOpPasswordEncoder.getInstance();
    }


}
