package com.ptteng.polyFinance.lgd.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.SmsVoiceVerifyCodeSender;
import com.github.qcloudsms.SmsVoiceVerifyCodeSenderResult;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author lujing
 * Create_at 2018/3/17 11:47
 */
public class SMSutil {
    
    
    /**
     * 用于发送短信验证码,已通过测试.
     * @param code  6位随机生成的验证码.
     * @param phoneNum 手机号码.
     */
    public static void sendSms(String code,String phoneNum)throws Exception {
        //假设短信模板 id 为 123，模板内容为：测试短信，{1}，{2}，{3}，上学。
        SmsSingleSender sender = null;
        
            sender = new SmsSingleSender(1400064448, "52f2139dcae50b8973e72c884652b808");
            ArrayList<String> params = new ArrayList<String>();
            params.add(code);
            params.add("15");
            SmsSingleSenderResult result = sender.sendWithParam("86", phoneNum, 96383, params, "", "", "");
            System.out.println(result);
        
    }
    
    /**
     * 用于发送语音验证码(不过因为权限原因,个人用户无法使用,所以弃用.)
     * @param code  6位数验证码
     * @param phoneNum  手机号码
     */
    public static void sendVoiceSms(String code,String phoneNum){
        //语音验证码发送
        SmsVoiceVerifyCodeSender smsVoiceVerifyCodeSender = new SmsVoiceVerifyCodeSender(1400064448, "52f2139dcae50b8973e72c884652b808");
        SmsVoiceVerifyCodeSenderResult smsVoiceVerifyCodeSenderResult = null;
        try {
            smsVoiceVerifyCodeSenderResult = smsVoiceVerifyCodeSender.send("86",
                    phoneNum, code,2,"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(smsVoiceVerifyCodeSenderResult);
    }
    
//    public static void main(String[] args) {
////        sendSms("123456","18008082290");
//        sendVoiceSms("123456","18008082290");
//    }
    
    public static String random(int ix){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<ix;i++)
        {
            Integer a ;
            a =random.nextInt(10);
            sb.append(a);
        }
        
        return sb.toString();
    }
    
}
