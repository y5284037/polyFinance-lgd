package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.model.Product;
import com.ptteng.polyFinance.lgd.model.Settings;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;
import com.ptteng.polyFinance.lgd.service.ProductService;
import com.ptteng.polyFinance.lgd.service.SettingsService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.TimeUtil;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * InvestRecord  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class InvestRecordController {
    private static final Log log = LogFactory.getLog(InvestRecordController.class);
    
    @Autowired
    private InvestRecordService investRecordService;
    @Autowired
    private SettingsService settingsService;
    @Autowired
    private ProductService productService;
    
    
    /**
     * 查询用户投资记录列表
     *
     * @param id           当前登录用户id
     * @param page         当前显示页数
     * @param size         每页数量
     * @param investStatus 产品状态
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/a/u/investRecord/list", method = RequestMethod.GET)
    public String getUserInverstRecord(Long id, Integer page, Integer size,
                                       Integer investStatus, ModelMap modelMap) {
        System.out.println(investStatus);
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        if (CommonUtil.isEmpty(id, investStatus)) {
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/investRecord/json/investRecordListJson";
        }
        
        try {
            List<Long> ids = investRecordService.getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(id, investStatus, start, size);
            List<InvestRecord> investRecords = investRecordService.getObjectsByIds(ids);
            modelMap.addAttribute("investRecordList", investRecords);
            modelMap.addAttribute("code", 0);
            modelMap.addAttribute("total", investRecordService.countInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(id, investStatus));
            modelMap.addAttribute("size", size);
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/investRecord/json/investRecordListJson";
    }
    
    
    /**
     * 查询单条投资记录详情
     *
     * @param id       投资记录ID
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/a/u/investRecord/{id}", method = RequestMethod.GET)
    public String getInvestRecord(@PathVariable Long id, ModelMap modelMap) {
        try {
            InvestRecord investRecord = investRecordService.getObjectById(id);
            modelMap.addAttribute("investRecord", investRecord);
            modelMap.addAttribute("code", 0);
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/investRecord/json/investRecordDetailJson";
    }
    
    
    /**
     * @param modelMap
     * @param id       用户ID
     * @param page     页数
     * @param size     页容量
     * @return
     */
    @RequestMapping(value = "/a/u/investRecord/again", method = RequestMethod.GET)
    public String getAgainList(ModelMap modelMap, Long id, Integer page, Integer size) {
        if (CommonUtil.isEmpty(id)) {
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/investRecord/json/againRecordListJson";
            
        }
        if (CommonUtil.isEmpty(page)) {
            page = 1;
        }
        if (CommonUtil.isEmpty(size)) {
            size = 10;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        try {
            List<Long> ids = investRecordService.getInvestRecordIdsByUserIdOrderByCreateAt(id, start, size);
            List<InvestRecord> investRecords = investRecordService.getObjectsByIds(ids);
            Set<Long> productIds = new HashSet<>();//set是为了给ID去重
            for (InvestRecord investRecord : investRecords) {
                productIds.add(investRecord.getProductId());
            }
            List<Product> products = productService.getObjectsByIds(new ArrayList<>(productIds));
            Map<Long, Integer> map = new HashMap<>();
            for (Product product : products) {
                map.put(product.getId(), product.getProductStatus());
            }
            List<InvestRecord> matchRecords = new ArrayList<>();
            for (InvestRecord investRecord : investRecords) {
                if (map.get(investRecord.getProductId()) == 0) {
                    matchRecords.add(investRecord);
                }
            }
            
           /* Set<InvestRecord> set = new TreeSet<>(new Comparator<InvestRecord>() {
                @Override
                public int compare(InvestRecord o1, InvestRecord o2) {
                    if (o1.getValueDay() - o2.getValueDay() > 0) {
                        return 1;
                    } else if (o1.getValueDay() - o2.getValueDay() < 0) {
                        return -1;
                    }
                    return 1;
                }
            });
            set.addAll(matchRecords);
            
            Object[] arr = set.toArray();
            InvestRecord noobInvestRecord = (InvestRecord) arr[0];*/
            InvestRecord noobInvestRecord = Collections.min(matchRecords);
            System.out.println(noobInvestRecord);
            List<InvestRecord> match1Records = new ArrayList<>();
            Settings settings = settingsService.getObjectById(1L);
            int days = settings.getInvsetExpireWarn();
            for (InvestRecord record : matchRecords) {
                if ((record.getValueEndDay() - TimeUtil.getDaysTimeStamp(days)) <= TimeUtil.getZeroTimeStamp(new Date().getTime()) && record.getValueEndDay() > System.currentTimeMillis() && record.getId() > noobInvestRecord.getId()) {
                    match1Records.add(record);
                }
            }
            modelMap.addAttribute("againRecords", match1Records);
            modelMap.addAttribute("code", 0);
//            modelMap.addAttribute("total",)
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/investRecord/json/againRecordListJson";
        
    }
    
    
    @RequestMapping(value = "/a/u/investRecord", method = RequestMethod.POST)
    public String buyProduct() {
        
        
        return "";
    }
}

