package org.starrier.sky.ladder.basic.datetimes;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author starrier
 * @date 2020/12/14
 */
public class DateTimes {

    public static void main(String[] args) {
        getDateTime();
        getTimestampYesterday();
    }


    public static void getDateTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day - 1);
        Timestamp startTimeStamp = new Timestamp(calendar.getTimeInMillis());
        System.out.println("start timestamp ："+startTimeStamp);




    }

    public static void getTimestampYesterday(){

        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,999);

        Timestamp endTimeStamp = new Timestamp(calendar.getTimeInMillis());
        System.out.println("end timestamp ："+endTimeStamp);
    }
}
