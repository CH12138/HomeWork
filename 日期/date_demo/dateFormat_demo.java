package date_demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateFormat_demo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();

        //日期格式化
        //父类引用指向子类对象
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        //日期格式化为字符串
        String s1 = df.format(date);
        System.out.println(s1);

        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        s1= df.format(date);
        System.out.println("s1="+s1);


        df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        s1= df.format(date);
        System.out.println("s1="+s1);

        df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒SSS毫秒");
        s1= df.format(date);
        System.out.println("s1="+s1);

        df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒SSS毫秒");
        s1= df.format(date);
        System.out.println("s1="+s1);

        df = new SimpleDateFormat("yyyy年第www周,这个月的第FF周,这个月的第dd天");
        s1= df.format(date);
        System.out.println("s1="+s1);


        //字符串转化为日期
        String s="2019-5-6";
        //实例化日期格式化类
        df = new SimpleDateFormat("y-M-d");

        Date date1 = df.parse(s);
        System.out.println("转换后的Date对象："+date);

        System.out.println("--------------2--------------");
        s="2019-3-4 17:18:23";
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = df.parse(s);
        System.out.println("转换后的Date对象："+date);

        System.out.println("--------------3--------------");
        s="2019-3-4 5:18:23";
        df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        date = df.parse(s);
        System.out.println("转换后的Date对象："+date);

        System.out.println("--------------4--------------");
        s="2019/3/4  5:18:23";
        df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        date = df.parse(s);
        System.out.println("转换后的Date对象："+date);

        System.out.println("--------------5--------------");
        s="2019年3月4日                5时18分23秒";
        df = new SimpleDateFormat("yyyy年MM月dd日    HH时mm分ss秒");
        date = df.parse(s);
        System.out.println("转换后的Date对象："+date);
    }
}
