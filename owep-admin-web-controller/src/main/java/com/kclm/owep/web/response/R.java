/**************************
 * xxx 公司版权所有，未经同意，不可以随意复制、转发
 */
package com.kclm.owep.web.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/******************************************
 * 统一封装的返回数据类型
 *
 * @author yejf
 * @date 2024-01-23
 * @time 16:09
 * @package com.kclm.owep.web.response
 */
@Data
@NoArgsConstructor
@ToString(exclude = {"data"})
public class R<T> {

    private int code; // 响应码
    private String message; // 响应消息
    private T data; // 响应数据

    public R(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public R(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static R success() {
        R r = new R(200, "success");
        return r;
    }

    public static R error() {
        R r = new R(500, "error");
        return r;
    }

    public static R ok(String message) {
        R r = new R(200, message);
        return r;
    }

    public static R failure(String message) {
        R r = new R(500, message);
        return r;
    }

    public R setData(T data) {
        this.data = data;
        return this;
    }
}
