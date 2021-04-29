package com.notepad.utils;

/**
 * 500 服务器错误
 * 200 上传成功
 * 403 不允许发布,拉黑
 * 400 数据出现问题
 * 401  未登录
 * 1000 非法入侵
 *
 */

public enum CodeEnum {
    /**
     * 成功
     */
    SUCCESS(200, "ok"),

    /**
     * 参数不齐全或参数错误
     */
    BAD_REQUEST(400,"参数不正确");


    private Integer code;
    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
