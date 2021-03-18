package com.gnuoynawh.working.reference.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    /**
     * 현재시간
     */
    public static String getNow() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm", Locale.KOREA);
        Date currentTime = new Date();
        return dateFormat.format(currentTime);
    }

    /**
     * 오늘 날짜
     */
    public static String getToday() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
        Date currentTime = new Date();
        return dateFormat.format(currentTime);
    }

    /**
     * yyyyMMdd > yyyy-MM-dd
     * @param date
     * @return
     */
    public static String getDateString(String date) {
        if(date == null) {
            return "";
        }

        SimpleDateFormat before = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
        SimpleDateFormat after = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

        try {
            Date tempDate = before.parse(date);
            return after.format(tempDate);
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * hhmm >> hh:mm
     * mmss >> mm:ss
     * @param time
     * @return
     */
    public static String getTimeString(String time) {
        return time.substring(0,2) + ":" + time.substring(2,4);
    }

    /**
     * 요일 구하기
     * @return
     */
    public static String getDate(String date) {
        if(date == null) {
            return "";
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);

        try {
            Date tempDate = format.parse(date);

            Calendar cal = Calendar.getInstance();
            cal.setTime(tempDate);
            int dayNum = cal.get(Calendar.DAY_OF_WEEK);

            switch (dayNum) {
                case 1: return "일";
                case 2: return "월";
                case 3: return "화";
                case 4: return "수";
                case 5: return "목";
                case 6: return "금";
                case 7: return "토";
            }

        } catch (ParseException e) {
        }

        return "";
    }

}
