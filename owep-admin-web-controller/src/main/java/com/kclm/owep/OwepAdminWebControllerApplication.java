package com.kclm.owep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/****************
 * 整个应用部署时，需要启动的类
 * 注1：Spring Boot默认是启动事务管理器的，也就是@EnableTransactionManagement是自动打开的，只需要在
 * 做申明式事务的类或public方法上面使用 @Transactional 注解指定即可
 * 注2：Spring Boot默认是开启 Spring AOP的。
 * 注3：Spring Boot 默认是开启 WEB MVC的
 */
@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//使得 Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册,无需其它代码
@ServletComponentScan
public class OwepAdminWebControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OwepAdminWebControllerApplication.class, args);
    }


}

