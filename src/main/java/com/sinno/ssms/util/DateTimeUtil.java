package com.sinno.ssms.util;

import org.apache.logging.log4j.util.Strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.sinno.ssms.constant.CommonConstant.DEFAULT_TIMEZONE;

public class DateTimeUtil {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String getCurrentDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    public static String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    public static LocalDate getDate(String dateStr) {
        return LocalDate.parse(dateStr);
    }
}
