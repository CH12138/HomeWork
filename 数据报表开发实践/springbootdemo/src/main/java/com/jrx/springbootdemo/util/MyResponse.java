package com.jrx.springbootdemo.util;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: CH
 * @Date: 2020/6/6 18:04
 */

@Configuration
public class MyResponse<T> {
    //返回数据
    private T data;

    //返回码
    private Integer code;

    //返回描述
    private String msg;

    public MyResponse(){

    }

    public MyResponse(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public MyResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
