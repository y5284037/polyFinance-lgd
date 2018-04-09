package com.ptteng.polyFinance.lgd.payutil.fuiou;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.polyFinance.lgd.payutil.ConfigReader;
import com.ptteng.polyFinance.lgd.payutil.HttpPostUtil;
import com.ptteng.polyFinance.lgd.payutil.fuiou.util.XMLUtil;
import com.qding.common.util.XmlUtil;
import org.jdom2.JDOMException;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lujing
 * Create_at 2018/4/4 17:53
 */
public class HttpPayCallBack {
    private static final String ORDER_QRY_URL = ConfigReader.getString("order_qry_url_1");
    
    public static String queryOrderStatus(String mchntOrderId) {
        try {
            String version = "2.0";
            String mchntCd = ConfigReader.getString("h5_mchnt_cd");
            String mchntKey = ConfigReader.getString("h5_mchnt_key");
            
            OrderQryByMSsn data = new OrderQryByMSsn();
            data.setMchntCd(mchntCd);
            data.setMchntOrderId(mchntOrderId);
            data.setRem1("");
            data.setRem2("");
            data.setRem3("");
            data.setVersion(version);
            Map<String, String> params = new HashMap<String, String>();
            params.put("FM", data.buildXml(mchntKey));
            String respStr = HttpPostUtil.postForward(ORDER_QRY_URL, params);
            JSONObject json = XMLUtil.xml2JSON(respStr.getBytes("utf-8"));
           
            String RESPONSECODE = json.getJSONObject("RESPONSE").getJSONArray("RESPONSECODE").getString(0);
            
            return RESPONSECODE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "系统异常";
        }
    }
    
    public static void main(String[] args) {
      
        String res = queryOrderStatus("JXYK520180406114212055");
    
        System.out.println(res);
    }
}
