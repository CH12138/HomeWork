package com.jrx.springbootdemo.util;

/**
 * @Author: CH
 * @Date: 2020/6/9 21:56
 */
public enum LogEnum {
    BUSSINESS("bussiness"),
    PLATFORM("platform"),
    DB("db"),
    EXCEPTION("exception");
    private String category;
    LogEnum(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

}
