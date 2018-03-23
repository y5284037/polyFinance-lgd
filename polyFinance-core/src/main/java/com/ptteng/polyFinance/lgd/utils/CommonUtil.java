package com.ptteng.polyFinance.lgd.utils;

/**
 * @author: Arike
 * @program: polyFinance-lgd
 * @description: 常用工具类
 * @create: 2018/3/20 14:35
 */

public class CommonUtil {
    
    /**
     * 用于判断字符参数是否为 "" or null.
     *
     * @param args 可变参数
     * @return false为非空
     */
    public static boolean isEmpty(Object... args) {
        boolean a = false;
        for (Object arg : args) {
            if (arg instanceof String) {//判断是否是String的实例
                if ("".equals(arg)) {//判断是否为空串
                    a = true;
                }
            } else {
                if (arg == null) {//非String类型,只用判断是否为null
                    a = true;
                }
            }
            
        }
        return a;
    }
    
    
}
