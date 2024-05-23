package com.kclm.owep.web.security;

import com.kclm.owep.web.response.R;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*****
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends Throwable {

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        e.printStackTrace();
        return R.failure(StringUtils.hasLength(e.getMessage())? e.getMessage() : "操作失败");
    }

}
