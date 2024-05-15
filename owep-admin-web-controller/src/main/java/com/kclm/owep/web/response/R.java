package com.kclm.owep.web.response;

import java.io.Serializable;

/**************************
 * 封装了一个统一的返回类对象
 *  此类于2024年5月12号进行了更新【考虑到了前端所用的数据，message的默认值没有变： 成功还是success, 失败是 error】
 *
 * @author yejf
 * @param <T>
 */
public class R<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    //私有化构造
    private R(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //提供静态方法来创建R对象
    private static <T> R<T> restResult(int code, String message, T data) {
        return new R<>(code, message, data);
    }

    //提供对外的工厂方法
    public static <T> R<T> success() {
        return restResult(200, "success", null);
    }

    /***************
     * 指定data 正确返回
     * @param data
     * @return
     * @param <T>
     */
    public static <T> R<T> success(T data) {
        //
        return restResult(200, "success", data);
    }

    /************************
     * 以状态码为500，“操作失败”做为错误消息返回
     * @return
     * @param <T>
     */
    public static <T> R<T> failure() {
        //
        return restResult(500, "error", null);
    }

    /***************
     * 仅自定义错误消息，状态码固定为500
     * @param message
     * @return
     * @param <T>
     */
    public static <T> R<T> failure(String message) {
        //
        return restResult(500, message, null);
    }

    /*****************************
     * 自定义状态码和错误信息
     * @param code
     * @param message
     * @return
     * @param <T>
     */
    public static <T> R<T> failure(int code , String message) {
        //
        return restResult(code, message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;

    }
}
