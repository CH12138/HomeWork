package date_demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class time_demo {
    public static void main(String[] args) {

//       --------------------------------Clock-----------
        System.out.println("----------------------------------------Clock");
        //获取系统默认时区（当前时间）
        Clock  clock1 = Clock.systemDefaultZone();
        System.out.println(clock1);

        System.out.println(clock1.instant());
        System.out.println(clock1.millis());


        //获取系统时钟，并将其转换成使用UTC时区的日期和时间
        Clock clock = Clock.systemUTC();
        System.out.println(clock);

        System.out.println(clock.instant());
        System.out.println(clock.millis());

        System.out.println("---------------------------------------Instant");
        //Instant类也可以用来创建老的java.util.Date对象
        Instant instant = clock.instant();
        Date date = Date.from(instant);
        System.out.println(date.toString());

//        ---------------------------------------ZoneId-----------
        System.out.println("---------------------------------------ZoneId-----------");
        // 获取一组可见的时区ID，eg：Asia/Aden, America/Cuiaba, Etc/GMT+9等
        System.out.println(ZoneId.getAvailableZoneIds());
        //获取系统默认时区
        System.out.println(ZoneId.systemDefault());
        // 从ID获取一个 ZoneId的实例，确保该ID有效并且可供使用。
        ZoneId zone1 = ZoneId.of("Asia/Shanghai");
        //获取此ID的时区规则，允许执行计算
        System.out.println(zone1.getRules());
        //获取唯一的时区ID。
        System.out.println(zone1.getId());

//        -------------------------------------------LocalTime(本地时间）
        System.out.println("-------------------------------------------LocalTime(本地时间）");
//        LocalTime是一个不可变的日期时间对象，代表一个时间，通常被看作是小时 - 秒。 时间表示为纳秒精度。 例如，值“13：45.30.123456789”可以存储在LocalTime
        LocalTime time = LocalTime.now();
        System.out.println(time);

        //根据不同的时区显示不同时区的时间
        ZoneId zoneId = ZoneId.of("Europe/Berlin");
        LocalTime now1 = LocalTime.now(zoneId);
        System.out.println(now1);

//        ----------------------------------------LocalDate(本地日期）
        System.out.println("----------------------------------------LocalDate(本地日期）");
//        LocalDate 表示了一个确切的日期（eg： 2014-03-11）。该对象值是不可变的，使用方式和LocalTime基本一致。
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getMonth());

        LocalDate localDate1 = LocalDate.of(2020,5,20);
        System.out.println(localDate1);

        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getYear());
        System.out.println(localDate);

//        ----------------------------------------LocalDateTime(本地日期时间）
        System.out.println("----------------------------------------LocalDateTime(本地日期时间）");
        //获取当前的日期和时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());
        localDateTime  = LocalDateTime.of(2020,9,5,6,25,32,5);
        System.out.println(localDateTime);

//        --------------------------------------------ZonedDateTime(日期时间和时区信息）
//        使用ZonedDateTime，它保存有ISO-8601日期系统的日期和时间，而且有时区信息。
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

//        格式化时间
        System.out.println("----------------------------格式化时间");

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate= dtf.format(ldt);
        System.out.println(strDate);

        LocalDateTime newDate = ldt.parse(strDate, dtf);
        System.out.println(newDate);

    }
}
