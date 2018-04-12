package com.ptteng.polyFinance.lgd.JobDetail;

import com.gemantic.common.util.MyListUtil;
import com.ptteng.polyFinance.lgd.model.Count;
import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.service.CountService;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;
import com.ptteng.polyFinance.lgd.service.ProductService;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import com.ptteng.polyFinance.lgd.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.rmi.Naming;
import java.util.*;

/**
 * @author lujing
 * Create_at 2018/4/9 9:23
 */
public class CountJob {
    private static final Logger logger = LoggerFactory.getLogger(CountJob.class);
    private CountService countService;
    private InvestRecordService investRecordService;
    private ProductService productService;
    
    /**
     * 定时任务：统计每个产品，每天的销量
     */
    public void countProductService() {
        Long nowTime = System.currentTimeMillis();
        Long oneDayTimeMillis = TimeUtil.getDaysTimeStamp(1);
        Map<String, Object> param = DynamicUtil.getInvestRecordBycreateAt(nowTime - oneDayTimeMillis, nowTime);
        
        try {
            
            investRecordService = (InvestRecordService) Naming.lookup("//localhost:20310/InvestRecordRMIService");
            productService = (ProductService) Naming.lookup("//localhost:20310/ProductRMIService");
            countService = (CountService) Naming.lookup("//localhost:20311/CountRMIService");
            
            List<Long> productIds = productService.getProductIds(0, Integer.MAX_VALUE);
            List<Long> investIds = investRecordService.getIdsByDynamicCondition(InvestRecord.class, param, 0, Integer.MAX_VALUE);
            List<InvestRecord> investRecordList = investRecordService.getObjectsByIds(investIds);
            List<Count> counts = new ArrayList<>();
            
            
            for (Long id : productIds) {
                List<InvestRecord> investRecordTemp = new ArrayList<>();
                
                for (InvestRecord investRecord : investRecordList) {
                    if (id.equals(investRecord.getProductId())) {
                        investRecordTemp.add(investRecord);
                    }
                }
                
                if (investRecordTemp.size() > 0) {
                    BigDecimal countAmount = new BigDecimal("0");
                    for (InvestRecord investRecord : investRecordTemp) {
                        countAmount = countAmount.add(investRecord.getInvestAmount());
                    }
                    
                    List<Long> userIds = MyListUtil.getList(InvestRecord.class.getDeclaredField("userId"), investRecordTemp);
                    Set<Long> userId = new HashSet<>();
                    userId.addAll(userIds);
                    
                    Count a = new Count();
                    a.setProductId(id);
                    a.setDate(nowTime);
                    a.setUpdateAt(nowTime);
                    a.setPurchaseTimes(investRecordTemp.size());
                    a.setPurchaseAmount(countAmount);
                    a.setPurchasePeople(userId.size());
                    counts.add(a);
                }
                
            }
            countService.insertList(counts);
            
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
