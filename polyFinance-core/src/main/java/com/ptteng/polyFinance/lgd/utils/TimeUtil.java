package com.ptteng.polyFinance.lgd.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: Arike
 * @program: polyFinance-lgd
 * @description: 用于获取各个时间点时间戳的工具类
 * @create: 2018/3/31 14:53
 */

public class TimeUtil {
    
    
    /**
     * 获取当天凌晨的时间戳
     * @param currentTime 当前时间戳
     * @return
     */
    public static Long getZeroTimeStamp(Long currentTime){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime().getTime();
    }
    
    /**
     * 获取约定天数的总毫秒数
     * @param days 天数
     * @return
     */
    public static Long getDaysTimeStamp(int days){
        return  days * 24 * 60 * 60 * 1000L;
    }
    
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");
        System.out.println(sp.format(date));
        System.out.println(sp.format(new Date(getZeroTimeStamp(date.getTime()))));
        System.out.println(new Date().getTime()+ getDaysTimeStamp(6));
    }
}
