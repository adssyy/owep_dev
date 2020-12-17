package com.kclm.owep;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



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

    @Bean
    public ObjectMapper serializingObjectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .modules(module)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .build();
        return objectMapper;

    }
}

