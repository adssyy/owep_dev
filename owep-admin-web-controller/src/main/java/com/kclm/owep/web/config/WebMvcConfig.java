package com.kclm.owep.web.config;

import com.kclm.owep.utils.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/******************
 * @Author yejf
 * @Description 如果需要添加Spring Mvc相关的配置，可以在此添加, 此类也需要手动去扫描
 */
@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {

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


    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                log.debug("localDateTimeConverter============="+source);
                return DateUtil.stringToLocalDateTime(source);
            }
        };
    }

    /**
     * 接收前端datetime参数
     * @return 日期转换器
     */
    @Bean
    public Converter<String, LocalDate> dateConvert() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        };
    }

}
