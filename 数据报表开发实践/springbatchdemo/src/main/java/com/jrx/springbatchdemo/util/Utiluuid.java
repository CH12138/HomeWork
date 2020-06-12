package com.jrx.springbatchdemo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @Author: CH
 * @Date: 2020/6/11 0:04
 */
public class Utiluuid {
    public static String getUuid(){
        String uuid = "";
        LocalDateTime date;
        date = LocalDateTime.now();
        for(int i=0;i<10;i++){
            uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0,9);
            String format = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            uuid= uuid +"_"+ format.replace("-","");
        }
        return uuid;
    }
}