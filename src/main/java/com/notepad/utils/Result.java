package com.notepad.utils;

import java.io.Serializable;

/**
 * 500 服务器错误
 * 200 上传成功
 * 403 不允许发布,拉黑
 * 400 数据出现问题
 * 401  未登录
 * 1000 非法入侵
 *
 */

public class Result<T> implements Serializable {

    //状态码
    private Integer status;
    //状态
    private String message;
    //返回封装数据
    private T data;

    public Result() {

    }

    public Result(Integer status) {
        this.status = status;
    }

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //不返回数据构造方法
    public Result(CodeEnum codeEnum) {
        this.status = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    //返回数据构造方法
    public Result(CodeEnum codeEnum, T data) {
        this(codeEnum);
        this.data = data;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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



    //请求成功（不返回数据）
    public static <T> Result <T> success(){
        return new Result <T>(CodeEnum.SUCCESS);
    }

    //请求成功（返回数据）
    public static <T> Result <T> success(T data){
        return new Result <T>(CodeEnum.SUCCESS,data);
    }

    //参数格式不正确
    public static <T> Result <T> badRequest(){
        return new Result <T>(CodeEnum.BAD_REQUEST);
    }

    //.......



    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}