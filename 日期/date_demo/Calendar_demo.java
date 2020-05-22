package date_demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calendar_demo {
    public static void main(String[] args) {

        //-------------------------------------------get方法
        //Calendar是抽象类,不能直接创建对象
        //父类引用指向子类对象  方式1：
//        Calendar cal = new GregorianCalendar();

        //方式2
		Calendar cal  = Calendar.getInstance();


        //获取年，月，日，时，分，秒 ，毫秒  ，一年的第几天，一年的第几周，一个月的第几周，一周的第几天（周索引）
        // 月：（0-11 ） 表示1-12月  ，周索引：（1-7） 表示的周日到周六 ，周日表示1,周一是2，以此类推，周六是7
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int date1 = cal.get(Calendar.DATE);
        int date2 = cal.get(Calendar.DAY_OF_MONTH);

        int hour1 = cal.get(Calendar.HOUR);
        int hour2 = cal.get(Calendar.HOUR_OF_DAY);

        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        //毫秒
        int millSec = cal.get(Calendar.MILLISECOND);

        //一年的第几天
        int dayIndex = cal.get(Calendar.DAY_OF_YEAR);
        //一年的第几周
        int weekIndex = cal.get(Calendar.WEEK_OF_YEAR);
        //一个月的第几周
        int weekIndex2 = cal.get(Calendar.WEEK_OF_MONTH);
        //一周的第几天
        int  weekIndex3 = cal.get(Calendar.DAY_OF_WEEK);

        //一个月的第几周
        // 1-7 :1  ,8-14 :2,  15-21: 3,  22--28:4  29---0 ,-1, 5
        int  weekIndex4 = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);

        System.out.println("年："+year+"  月："+month+"  日："+date1+"  日："+date2 +"  时："+hour1+"  时："+hour2+"  分："+min+"  秒："+sec+"  毫秒："+millSec);
        System.out.println("一年的第几天："+dayIndex+",一年的第几周："+weekIndex+",一个月的第几周："+weekIndex2
                +",一周的第几天："+weekIndex3+",一周第几天："+weekIndex4);

        System.out.println("周一的周索引："+Calendar.MONDAY);

        //--------------------------------------set方法
        //2019-10-28

        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, 9);
//		cal.set(Calendar.DATE, 28);
        cal.set(Calendar.DAY_OF_MONTH, 28);

        //Calendar和Date转换，getTime();
        Date date =  cal.getTime();

        DateFormat dateFormat = new SimpleDateFormat("y-M-d");
        String s = dateFormat.format(date);
        System.out.println(s);
        System.out.println("一年的第几天："+cal.get(Calendar.DAY_OF_YEAR));

        //Date装换为Calendar，setTime(date)
        cal.setTime(date);
        System.out.println("Calendar对象"+cal);

        //当前时间加30天
        cal.add(Calendar.DATE, 30);
        //减50天
        cal.add(Calendar.DATE, -50);
        System.out.println("当前的几月几号："+(cal.get(Calendar.MONTH)+1)+"月\t"+cal.get(Calendar.DATE));

//        Calender的月份是从0开始的，但日期和年份是从1开始的
//        将日期设为0以后，月份变成了上个月，但月份可以为0
        Calendar c1 = Calendar.getInstance();
        c1.set(2019, 2, 1);
        System.out.println(c1.get(Calendar.YEAR)
                +"-"+c1.get(Calendar.MONTH)
                +"-"+c1.get(Calendar.DATE));
        c1.set(2019, 2, 0);
        System.out.println(c1.get(Calendar.YEAR)
                +"-"+c1.get(Calendar.MONTH)
                +"-"+c1.get(Calendar.DATE));

    }
}
