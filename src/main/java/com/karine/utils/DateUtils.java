package com.karine.utils;

public class DateUtils {
    public static String fullYears(String date) {
        char c = date.charAt(date.length() - 1);
        switch (c) {
            case '1':
                return date + " год";
            case '2':
            case '3':
            case '4':
                return date + " года";
            default:
                return date + " лет";
        }
    }
}
