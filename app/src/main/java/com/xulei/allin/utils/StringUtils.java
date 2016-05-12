package com.xulei.allin.utils;

import java.util.regex.Pattern;

/**
 * Created by xulei on 2016/5/12.
 */
public class StringUtils {

    public static void isIdCard(String idNum) {
        //定义判别用户身份证号的正则表达式（要么是15位，要么是18位，最后一位可以为字母）
        Pattern p = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
        p.matcher(idNum).find();
    }
}