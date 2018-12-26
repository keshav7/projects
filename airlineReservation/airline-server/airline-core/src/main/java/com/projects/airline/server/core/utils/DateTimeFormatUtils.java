package com.projects.airline.server.core.utils;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateTimeFormatUtils {
    private static final DateTimeFormatter _24_HOUR_TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm:ss");

    private static final DateTimeFormatter _12_HOUR_TIME_FORMATTER = DateTimeFormat.forPattern("hh:mm a");

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd");

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern(DATE_PATTERN);

    public static String formatDate(java.util.Date date) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static String fromLocalTime(LocalTime localTime) {
        return fromLocalTime(_24_HOUR_TIME_FORMATTER, localTime);
    }

    public static String fromLocalTime(DateTimeFormatter fmt, LocalTime localTime) {
        return localTime == null ? null : fmt.print(localTime);
    }

    public static LocalTime toLocalTime(String localTime) throws UnsupportedOperationException, IllegalArgumentException {
        return toLocalTime(_24_HOUR_TIME_FORMATTER, localTime);
    }

    public static LocalTime toLocalTime(DateTimeFormatter fmt, String localTime) throws UnsupportedOperationException,
            IllegalArgumentException {
        return localTime == null ? null : fmt.parseLocalTime(localTime);
    }

    public static java.util.Date toJavaDate(String date) throws UnsupportedOperationException, IllegalArgumentException {
        return toJavaDate(DATE_FORMAT, date);
    }

    public static Date toSqlDate(String date) throws UnsupportedOperationException, IllegalArgumentException {
        return toSqlDate(DATE_FORMAT, date);
    }

    public static Date toSqlDate(DateTimeFormatter fmt, String date) throws UnsupportedOperationException,
            IllegalArgumentException {
        return new Date(toJavaDate(fmt, date).getTime());
    }

    public static java.util.Date toJavaDate(DateTimeFormatter fmt, String date) throws UnsupportedOperationException,
            IllegalArgumentException {
        return date == null ? null : fmt.parseLocalDate(date).toDate();
    }

    public static Time toSqlTime(LocalTime localTime) {
        return localTime == null ? null : new Time(localTime.toDateTimeToday().getMillis());
    }
}