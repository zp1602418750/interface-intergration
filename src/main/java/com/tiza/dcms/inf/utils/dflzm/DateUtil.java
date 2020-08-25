package com.tiza.dcms.inf.utils.dflzm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    /**
     * 将系统当前系统时间格式化为  yyyy-MM-dd HH:mm:ss
     * @return 格式化后的字符串
     */
    public static String formatNow(){
        LocalDateTime now = LocalDateTime.now();
       return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
