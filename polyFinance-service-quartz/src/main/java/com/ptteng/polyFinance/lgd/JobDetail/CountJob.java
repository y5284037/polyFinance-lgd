package com.ptteng.polyFinance.lgd.JobDetail;

import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.service.CountService;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;
import com.ptteng.polyFinance.lgd.service.ProductService;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import com.ptteng.polyFinance.lgd.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.Naming;
import java.util.List;
import java.util.Map;

/**
 * @author lujing
 * Create_at 2018/4/9 9:23
 */
public class CountJob {
    private static final Logger logger = LoggerFactory.getLogger(CountJob.class);
    private CountService countService;
    private InvestRecordService investRecordService;
    private ProductService productService;
    
    public void countProductService() {
        Long nowTime = System.currentTimeMillis();
        Long oneDayTimeMillis = TimeUtil.getDaysTimeStamp(1);
        Map<String, Object> param = DynamicUtil.getInvestRecordBycreateAt(nowTime - oneDayTimeMillis, nowTime);
        
        try {
            investRecordService = (InvestRecordService) Naming.lookup("//localhost:20310/InvestRecordRMIService");
            productService = (ProductService) Naming.lookup("//localhost:20310/ProductRMIService");
            
            List<Long> productIds = productService.getProductIds(0, Integer.MAX_VALUE);
            List<Long> investIds = investRecordService.getIdsByDynamicCondition(InvestRecord.class, param, 0, Integer.MAX_VALUE);
            List<InvestRecord> investRecordList = investRecordService.getObjectsByIds(investIds);
            
            
            
            
            
        } catch (Throwable e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            logger.error(" countProductService error ...");
        }
        
        
    }
    
    
    public void sendMessage() {
        System.out.println("send messge");
    }
}
