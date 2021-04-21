package com.kclm.owep.web.config;

import com.kclm.owep.utils.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    //配置文件上传
    @Bean
    public MultipartResolver multipartResolver(){
        //创建一个CommonsMultipartResolver
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();

        //配置属性
        //配置每个文件大小
        //multipartResolver.setMaxUploadSizePerFile();
        //设置封面大小
        //multipartResolver.setMaxUploadSize();

        return multipartResolver;
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");//似乎spring security会造成默认静态资源路径失效，需要重配
////        但也不对，测试后发现已有 ["classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/", "/"]默认配置
//    }

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

    //LocalDateTime转换

    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                System.out.println("localDateTimeConverter============="+source);
                return DateUtil.stringToLocalDateTime(source);
            }
        };
    }

}
