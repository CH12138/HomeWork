package date_demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date_demo {
    public static void main(String[] args) throws ParseException {
        //初始化Date对象
        Date date = new Date();

        System.out.println(date);
        // 使用 toString() 函数显示日期时间
        System.out.println(date.toString());

        //这个构造函数接收一个参数，该参数是从1970年1月1日起的毫秒数
        Date date2 = new Date(1000000);

        System.out.println(date2);
        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
        long time = date.getTime();
        System.out.println(time);
        //用自1970年1月1日00:00:00 GMT以后time毫秒数设置时间和日期。
        date.setTime(time);
        System.out.println(date);



    }
}
