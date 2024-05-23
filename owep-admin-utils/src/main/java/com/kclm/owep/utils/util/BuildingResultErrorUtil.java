package com.kclm.owep.utils.util;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**********
 * 校验错误信息工具类
 */
public class BuildingResultErrorUtil {

    public static List<String> getUpdateAdminUserInfoErrorMessages(List<FieldError> fieldErrors) {
        List<String> sortedErrorMessages = new ArrayList<>();
        //fieldErrors 是不可修改的，创建一个可修改的副本
        List<FieldError> modifiableFieldErrors = new ArrayList<>(fieldErrors);

        // 自定义排序逻辑
        modifiableFieldErrors.sort(Comparator.comparing(fieldError -> {
            if ("realName".equals(fieldError.getField())) {
                return Integer.MIN_VALUE; // 真实姓名错误信息系统最优先
            } else if ("userPhone".equals(fieldError.getField())) {
                return 1; // 手机号错误
            }else if ("userEmail".equals(fieldError.getField())) {
                return 2; // 邮箱错误
            }  else {
                return Integer.MAX_VALUE; // 有效日期错误
            }
        }));
        // 提取错误消息并添加到列表中
        sortedErrorMessages.addAll(modifiableFieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
        return sortedErrorMessages;
    }


}
