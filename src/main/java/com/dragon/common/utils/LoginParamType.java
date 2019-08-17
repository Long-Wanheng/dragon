package com.dragon.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 19:49
 * @Description: ${Description}
 */
public class LoginParamType {
    public static final Integer EMAIL = 1;
    public static final Integer NAME = 2;
    public static final Integer PHONE = 3;

    private static final Pattern EMAIL_RULE = Pattern.compile("\\w+@\\w+(\\.\\w+)+");

    private static final Pattern PHONE_PATTERN = Pattern.compile("/^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/\n");

    public static Integer getLoginParamType(String parames) {
        Matcher emailMatcher = EMAIL_RULE.matcher(parames);
        Matcher phoneMatcher = PHONE_PATTERN.matcher(parames);
        if (emailMatcher.find()) {
            return EMAIL;
        } else if (phoneMatcher.find()) {
            return PHONE;
        } else {
            return NAME;
        }
    }
}
