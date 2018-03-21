package com.ptteng.polyFinance.lgd.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author lujing
 * Create_at 2018/3/18 13:57
 */
public class SecureUtil {
    /**
     * @return 长度20的盐值
     */
    public static String getSalt() {
        Random random = new SecureRandom();
        byte[] key = new byte[10];
        random.nextBytes(key);
        return byteToString(key);
    }
    
    
//    public static void main(String[] args) {
////        System.out.println(getSalt());
//        System.out.println(messageDigest("1234"));
//
//    }
    
    /**
     * 将字节数组转换为固定长度字符串
     *
     * @param bytes 字节数组
     * @return
     */
    public static String byteToString(byte[] bytes) {
        StringBuffer buffer = new StringBuffer();
        
        for (byte aByte : bytes) {
            String temp = Integer.toHexString(aByte & 0xff);
            
            buffer.append(temp);
        }
        
        return buffer.toString();
    }
    
    /**
     * 加密字符串
     *
     * @param message 待加密的密文
     * @return 加密后密文
     */
    public static String messageDigest(String message) {
        
        MessageDigest md;
        
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(message.getBytes("UTF-8"));
            
            return byteToString(digest);
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
