package com.dragon.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-11 00:44
 * @Description: ${Description}
 */
public class DateUtils {
    public static String currentDateString(String patten) {
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat(patten);
        return format.format(currentDate);
    }
}
