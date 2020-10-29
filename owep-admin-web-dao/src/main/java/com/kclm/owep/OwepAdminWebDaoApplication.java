package com.kclm.owep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/******************
 * @Author yejf
 * @Description TODO
 */
@SpringBootApplication
//@PropertySource(value = "classpath:application-dao.properties")
public class OwepAdminWebDaoApplication {

    /*public static void main(String[] args) {
        SpringApplication.run(OwepAdminWebDaoApplication.class, args);
    }*/

    public OwepAdminWebDaoApplication() {
        System.out.println("初始化OwepAdminWebDaoApplication...");
    }

}
