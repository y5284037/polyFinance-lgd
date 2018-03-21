package com.ptteng.polyFinance.lgd.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author lujing
 * Create_at 2018/3/19 15:05
 */
public class UserSerialNumUtil {
    public static String getUserSerialNum(Long id) {
    
        String yearLast = new SimpleDateFormat("yy", Locale.CHINESE).format(Calendar.getInstance().getTime());
        
        StringBuffer buffer = new StringBuffer();
        buffer.append("UK");
        buffer.append(yearLast);
        buffer.append(10);
        String idString = id.toString();
        
        if(idString.length()<7){
            for(int i = 0; i < 6-idString.length(); i++) {
                buffer.append(0);
            }
            buffer.append(idString);
        }else {
            Long ids = id -999999l;
            String ids2 =ids.toString();
            for(int i = 0; i < 6-ids2.length(); i++) {
                buffer.append(0);
            }
            
            buffer.append(ids.toString());
        }
        
        
        return buffer.toString();
    }
    
//    public static void main(String[] args) {
////        System.out.println(getUserSerialNum(1L));
////        System.out.println(getUserSerialNum(123L));
//        System.out.println(getUserSerialNum(1234567L));
//    }
}
