package com.ptteng.polyFinance.lgd.utils;

import com.ptteng.polyFinance.lgd.model.UserBank;

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
    
    public static String getUserBankInfo(UserBank userBank) {
        
        StringBuilder builder = new StringBuilder();
        builder.append(userBank.getBankName());
        builder.append("（");
        String cardNum = userBank.getCardNo();
        int a = cardNum.length();
        builder.append(cardNum.substring(a - 4));
        builder.append("）");
        return builder.toString();
    }
    
//    public static void main(String[] args) {
//        UserBank a = new UserBank();
//        a.setBankName("中国银行");
//        a.setCardNo("123432135465");
//        System.out.println(getUserBankInfo(a));
//    }


}
