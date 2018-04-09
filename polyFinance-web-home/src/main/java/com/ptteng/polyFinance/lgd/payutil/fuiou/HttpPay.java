package com.ptteng.polyFinance.lgd.payutil.fuiou;

import com.ptteng.polyFinance.lgd.payutil.ConfigReader;
import com.ptteng.polyFinance.lgd.payutil.Constants;
import com.ptteng.polyFinance.lgd.payutil.DateTimeUtil;
import com.ptteng.polyFinance.lgd.payutil.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.ptteng.polyFinance.lgd.payutil.fuiou.util.MD5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lujing
 * Create_at 2018/4/6 13:00
 */
public class HttpPay {
    
    private static final String BACK_URL = ConfigReader.getString("h5.back_url");
    private static final String HOME_URL = ConfigReader.getString("h5.home_url");
    private static final String RETURN_URL = ConfigReader.getString("h5.return_url");
    
    public static Map<String, String> getParam(Long userId, String amt, String bankCard, String name, String idType, String idNo, String type, String orderId) {
        
        
        StringBuffer orderPlain = new StringBuffer();
        
        String signPlain = type + "|" + "2.0" + "|" + Constants.H5_MCHNT_CD + "|" + orderId + "|" + userId
                + "|" + amt + "|" + bankCard + "|" + BACK_URL + "|" + name + "|" + idNo + "|" + idType + "|" + "0" + "|"
                + HOME_URL + "|" + RETURN_URL + "|" + Constants.H5_MCHNT_KEY;
        String sign = MD5.MD5Encode(signPlain);
        
        System.out.println("[签名明文:]" + signPlain);
        orderPlain.append("<ORDER>")
                .append("<VERSION>2.0</VERSION>")
                .append("<LOGOTP>0</LOGOTP>")
                .append("<MCHNTCD>").append(Constants.H5_MCHNT_CD).append("</MCHNTCD>")
                .append("<TYPE>").append(type).append("</TYPE>")
                .append("<MCHNTORDERID>").append(orderId).append("</MCHNTORDERID>")
                .append("<USERID>").append(userId).append("</USERID>")
                .append("<AMT>").append(amt).append("</AMT>")
                .append("<BANKCARD>").append(bankCard).append("</BANKCARD>")
                .append("<BACKURL>").append(BACK_URL).append("</BACKURL>")
                .append("<HOMEURL>").append(HOME_URL).append("</HOMEURL>")
                .append("<REURL>").append(RETURN_URL).append("</REURL>")
                .append("<NAME>").append(name).append("</NAME>")
                .append("<IDTYPE>").append(idType).append("</IDTYPE>")
                .append("<IDNO>").append(idNo).append("</IDNO>")
                .append("<REM1>").append(userId).append("</REM1>")
                .append("<REM2>").append(userId).append("</REM2>")
                .append("<REM3>").append(userId).append("</REM3>")
                .append("<SIGNTP>").append("md5").append("</SIGNTP>")
                .append("<SIGN>").append(sign).append("</SIGN>")
                .append("</ORDER>");
        System.out.println("[订单信息:]" + orderPlain.toString());
        Map<String, String> param = new HashMap<String, String>();
        param.put("VERSION", "2.0");
        param.put("ENCTP", "1");
        param.put("LOGOTP", "0");
        param.put("MCHNTCD", Constants.H5_MCHNT_CD);
        param.put("FM", orderPlain.toString());
        try {
            param.put("FM", DESCoderFUIOU.desEncrypt(orderPlain.toString(), DESCoderFUIOU.getKeyLength8(Constants.H5_MCHNT_KEY)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;
    }
    
    public static Long getInvestRecordId(String OrderId) {
        
        int index = OrderId.indexOf("|");
        String id = OrderId.substring(4, index);
        Long productId = Long.valueOf(id);
        return productId;
    }
    
    
}
