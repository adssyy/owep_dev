package com.kclm.owep.utils.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class GetCurrentUserNameUtil {

    public static String getCurrentUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//通过security 过滤器链得到目前用户凭证
        //通过authentication可以获取name,也可以获取 authorities的集合
        String name = authentication.getName();
        return name;
    }
}
