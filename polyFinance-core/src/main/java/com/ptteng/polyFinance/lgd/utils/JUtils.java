package com.ptteng.polyFinance.lgd.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: Arike
 * @program: polyFinance-lgd
 * @description: json工具类
 * @create: 2018/4/9 11:18
 */

public class JUtils {
    
    /**
     *
     * @param args 不定参数.
     *             如果仅有一个参数,必须为code状态码.
     *             另外最少有3个参数.从第2个参数开始数据总是成对出现. 数据名(String),数据
     *             示例
     *             第2参:"data" 第3参:list  第4参:"product" 第5参:product
     *             如果第2,3个参数都为integer,则第2个参数为size,第3个参数为total.(也必须成对出现)
     * @return
     */
    public static JSONObject getJSON(Object... args) {
        Properties properties = new Properties();
        try {
            properties.load(JUtils.class.getClassLoader().getResourceAsStream("message_zh_CN.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        json.put("code", args[0]);
        json.put("message", properties.getProperty(args[0].toString()));
        if (args.length > 2) {
            if (args[1] instanceof Integer && args[2] instanceof Integer) {
                json.put("size", args[1]);
                json.put("total", args[2]);
                for (int i = 3; i < args.length - 1; i++) {
                    json.put((String) args[i], args[i + 1]);
                    return json;
                }
            } else {
                for (int i = 1; i < args.length - 1; i++) {
                    json.put((String) args[i], args[i + 1]);
                }
                return json;
            }
        }
        return json;
    }
    
}