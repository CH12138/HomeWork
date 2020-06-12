package com.jrx.springbootdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: CH
 * @Date: 2020/6/9 21:57
 */
public class LogUtils {
    /**
     * 获取业务日志logger
     */
    public static Logger getBussinessLogger() {
        return LoggerFactory.getLogger(LogEnum.BUSSINESS.getCategory());
    }
    /**
     * 获取平台日志logger
     */

    public static Logger getPlatformLogger() {
        return LoggerFactory.getLogger(LogEnum.PLATFORM.getCategory());
    }
    /**
     * 获取数据库日志logger
     */
    public static Logger getDBLogger() {
        return LoggerFactory.getLogger(LogEnum.DB.getCategory());
    }

    /**
     * 获取异常日志logger
     */
    public static Logger getExceptionLogger() {
        return LoggerFactory.getLogger(LogEnum.EXCEPTION.getCategory());
    }

}
