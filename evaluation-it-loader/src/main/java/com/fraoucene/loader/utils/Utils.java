package com.fraoucene.loader.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by fraoucene on 16/11/2015.
 */
public class Utils {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss:SSS");

    public static Date durationFrom(long startTime) {
        long duration = System.currentTimeMillis() - startTime;
        return new Date(duration -  TimeZone.getDefault().getRawOffset());
    }

}
