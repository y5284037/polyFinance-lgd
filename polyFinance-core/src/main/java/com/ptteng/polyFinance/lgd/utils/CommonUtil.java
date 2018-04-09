package com.ptteng.polyFinance.lgd.utils;

import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.model.Product;
import com.ptteng.polyFinance.lgd.model.UserBank;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
    
    
    public static String getInvestComodatoNum(Product product, Long id) {
        String yearLast = new SimpleDateFormat("yy", Locale.CHINESE).format(Calendar.getInstance().getTime());
        if (id == null || product == null) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("UK");
        buffer.append(product.getRemark());
        buffer.append(yearLast);
        buffer.append("10");
        
        String idString = id.toString();
        
        if (idString.length() < 7) {
            for (int i = 0; i < 6 - idString.length(); i++) {
                buffer.append(0);
            }
            buffer.append(idString);
        } else {
            Long ids = id - 999999l;
            String ids2 = ids.toString();
            for (int i = 0; i < 6 - ids2.length(); i++) {
                buffer.append(0);
            }
            
            buffer.append(ids.toString());
        }
        
        return buffer.toString();
    }
    
    
    public static String getAgreeMentNum(Product product, Long id) {
        String yearLast = new SimpleDateFormat("yy", Locale.CHINESE).format(Calendar.getInstance().getTime());
        
        if (id == null || product == null) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("UK");
        buffer.append("ZQ");
        
        buffer.append(yearLast);
        buffer.append("10");
        
        String idString = id.toString();
        
        if (idString.length() < 7) {
            for (int i = 0; i < 6 - idString.length(); i++) {
                buffer.append(0);
            }
            buffer.append(idString);
        } else {
            Long ids = id - 999999l;
            String ids2 = ids.toString();
            for (int i = 0; i < 6 - ids2.length(); i++) {
                buffer.append(0);
            }
            
            buffer.append(ids.toString());
        }
        
        return buffer.toString();
        
        
    }
    
    
    public static void main(String[] args) {
    
    }
    
    public static BigDecimal getIncomeByDays(BigDecimal amt, BigDecimal productRate, Long start, Long end) {
        Integer days = TimeUtil.getDays(end - start);
        double a = amt.multiply(productRate).doubleValue() / 100;
        double b = a * days / 360;
        return new BigDecimal(b).setScale(2, BigDecimal.ROUND_FLOOR);
    }
    
    public static BigDecimal getUserTotalIncome(List<InvestRecord> invest) {
        BigDecimal a = new BigDecimal("0");
        for (InvestRecord o : invest) {
            a = a.add(o.getInvestAmount());
        }
        return a;
    }
}
