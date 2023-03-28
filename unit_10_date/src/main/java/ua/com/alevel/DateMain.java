package ua.com.alevel;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class DateMain {




    public static void main(String[] args) {



        long time = System.currentTimeMillis();
        System.out.println("time = " + time);
        Date date = new Date();
        Date now = new Date(time);
//        System.out.println("date = " + date);
//        System.out.println("now = " + now);
        Date afterOneHourse = new Date(time + 1000 * 60 * 60);
        System.out.println("afterOneHourse = " + afterOneHourse);

        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar);
        calendar.add(Calendar.DAY_OF_WEEK, -4);
        Date time1 = calendar.getTime();
        System.out.println("calendar = " + calendar);
        System.out.println("time1 = " + time1);


        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("offsetDateTime = " + offsetDateTime);
        ZoneId zoneId = ZoneId.of("Europe/Dublin");
        offsetDateTime.atZoneSameInstant(zoneId);
        System.out.println("offsetDateTime = " + offsetDateTime);

        OffsetDateTime offsetDateTime1 = OffsetDateTime.now(zoneId);
        System.out.println("offsetDateTime1 = " + offsetDateTime1);



    }



}






