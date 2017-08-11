package com.jmdroid.boxofficechart.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {
    public TimeUtil() {
    }

    public String getYesterdayDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();

        calendar.add(calendar.DATE, -1);
        String yesterdayDate = simpleDateFormat.format(calendar.getTime());
        return yesterdayDate;
    }
}

















