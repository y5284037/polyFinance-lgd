package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

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
    
    /**
     * 后台：查询用户投资记录列表
     *
     * @param model
     * @param userid                 用户id
     * @param productName            产品名称
     * @param valueDayStart          起息日期起
     * @param valueDayEnd            起息日期止
     * @param valueEndDayStart       到期日期起
     * @param valueEndDayEnd         到期日期止
     * @param investStatus           投资状态
     * @param comodatoNum            合同编号
     * @param intercreditorAgreement 债券协议号
     * @param page                   页数
     * @param size                   每页个数
     * @return
     */
    @RequestMapping(value = "/a/u/investRecord/list", method = RequestMethod.GET)
    public String getUserInvestRecord(ModelMap model, Long userid, String productName, Long valueDayStart, Long valueDayEnd, Long valueEndDayStart, Long valueEndDayEnd, Integer investStatus, String comodatoNum, String intercreditorAgreement, Integer page, Integer size) {
        
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
        
        log.info("pageList : page= " + start + " , size=" + size);
        
        Map<String, Object> param = DynamicUtil.getUserInvestRecord(userid, productName, valueDayStart, valueDayEnd, valueEndDayStart, valueEndDayEnd, investStatus, comodatoNum, intercreditorAgreement);
        try {
            List<Long> ids = investRecordService.getIdsByDynamicCondition(InvestRecord.class, param, start, size);
            List<InvestRecord> investRecordList = investRecordService.getObjectsByIds(ids);
            List<Long> countIds = investRecordService.getIdsByDynamicCondition(InvestRecord.class, param, start, size);
            Integer total = ids.size();
            
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            model.addAttribute("total", total);
            model.addAttribute("investRecordList", investRecordList);
            
        } catch (Throwable e) {
            log.error(e.getMessage());
            log.error("get investRecord list error,page is  " + start + " , size "
                    + size);
            
            model.addAttribute("code", -100);
            e.printStackTrace();
        }
        
        return "/polyFinance-lgd-server/investRecord/json/investRecordListJson";
    }
    
    
}

