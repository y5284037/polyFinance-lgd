package com.ptteng.polyFinance.lgd.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author lujing
 * Create_at 2018/1/6 13:37
 */
public class JwtUtils {
    
    /**
     *
     * @param id 需要添加到自定义属性中的值
     * @param secret 密匙
     * @return
     */
    public static String generateJwt(String id, String secret) {
    
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        SecretKey secretKey = ;
        Map<String, Object> map = new HashMap<>();
        map.put("ID", id);
    
        JwtBuilder builder = Jwts.builder()
//                .setId("1")                          //JWT_ID
//                .setAudience("mama")                //接受者
                .setClaims(new DefaultClaims(map))   //自定义属性
//                .setSubject("test")               //主题
//                .setIssuer("papa")               //签发者
//                .setIssuedAt(new Date())        //签发时间
//                .setNotBefore(new Date())      //失效时间
                .setExpiration(new Date(new Date().getTime() + 1000L * 60 * 24))  //过期时间
                .signWith(signatureAlgorithm, secret);   //签名算法以及密匙
        return builder.compact();   //返回jwt字符串
    }
    
    
}
