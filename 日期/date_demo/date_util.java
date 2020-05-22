package date_demo;

import java.util.Calendar;
import java.util.Date;

public class date_util {
    public static void showDate(Date date){
        Calendar cal  = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        System.out.println("年份："+year);
        int month = cal.get(Calendar.MONTH);
        System.out.println("月份："+(month+1));
        int jd = JD(month);
        System.out.println("季度："+jd);
        int week_year = cal.get(Calendar.WEEK_OF_YEAR);
        System.out.println("星期数："+week_year);
        int date_year = cal.get(Calendar.DAY_OF_YEAR);
        System.out.println("一年中的哪一天："+date_year);


    }
    public static int JD(int month){
        if(month==0||month==1||month==2||month==3){
            return 1;
        }else if(month==5||month==6||month==7||month==4){
            return 2;
        }else if(month==9||month==10||month==11||month==9){
            return 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        Date date = new Date();
        showDate(date);
    }
}
