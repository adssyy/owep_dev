package com.kclm.owep.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/******************
 * @Author yejf
 * @Description 如果需要添加Spring Mvc相关的配置，可以在此添加, 此类也需要手动去扫描
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Logger log = LoggerFactory.getLogger(WebMvcConfig.class);

    public WebMvcConfig() {
        System.out.println("===> 正在初始化 WebMvcConfig...");
        log.debug("Spring Boot创建了 WebMvcConfig对象....");
    }

   /* @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean();
        //设置属性
        lvfb.setValidationMessageSource(messageSource());
        //返回
        return lvfb;
    }*/

    /*****
     * 用来指定验证时要读取的资源文件
     * @return
     */
    /*@Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        //属性
        messageSource.setBasename("beanValidation");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(60);
        messageSource.setAlwaysUseMessageFormat(true);
        //
        return messageSource;
    }*/
}
