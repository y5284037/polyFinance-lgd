package com.ptteng.polyFinance.lgd.utils;

/**
 * @author: Arike
 * @program: polyFinance-lgd
 * @description: 测试
 * @create: 2018/3/21 16:12
 */

public class test {
    public static void main(String[] args) {
        String s="das.dasd.asda.asd.img";
        System.out.println(s.substring(s.lastIndexOf("."),s.length()));
        System.out.println(s.split("\\.")[s.split("\\.").length-1]);
    }
}
