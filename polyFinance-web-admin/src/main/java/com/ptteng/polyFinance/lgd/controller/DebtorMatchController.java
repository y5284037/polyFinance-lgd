package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.DebtorMatch;
import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.model.User;
import com.ptteng.polyFinance.lgd.service.DebtorMatchService;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;
import com.ptteng.polyFinance.lgd.service.UserService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * DebtorMatch  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class DebtorMatchController {
    private static final Log log = LogFactory.getLog(DebtorMatchController.class);
    
    @Autowired
    private DebtorMatchService debtorMatchService;
    @Autowired
    private InvestRecordService InvestRecordService;
    @Autowired
    private UserService userService;
    
    /**
     * 后台：推荐匹配
     *
     * @param model
     * @param page
     * @param debtStartTime 出借日期
     * @param debtEndTime   到期日期
     * @param amount        出借金额
     * @param size
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "a/u/debtorMatch/recommend/list", method = RequestMethod.GET)
    public String getDebtorMatchIdsByDebtorIdJsonList(ModelMap model, Integer page, Long debtStartTime, Long debtEndTime, BigDecimal amount, Integer size, Long id) throws Exception {
        
        List<InvestRecord> matchedList = new ArrayList<>();
        
        //金额相等的查询条件
        Map<String, Object> param1 = new HashMap<>();
        param1.put("@table", "invest_record");
        param1.put("amount & =", amount);
        param1.put("invest_status & =", 0);
        param1.put("matched & =", 0);
        
        //投资期限匹配的
        Map<String, Object> param2 = new HashMap<>();
        param2.put("@table", "invest_record");
        param2.put("value_end_day & <=", debtEndTime);
        
        param2.put("invest_status & =", 0);
        param2.put("matched & =", 0);
        try {
            //1.金额相等的投资记录
            List<Long> investRecordIds = InvestRecordService.getIdsByDynamicCondition(InvestRecord.class, param1, 0, Integer.MAX_VALUE);
            List<InvestRecord> investRecordList1 = InvestRecordService.getObjectsByIds(investRecordIds);
            if (investRecordList1 != null) {
                matchedList.addAll(investRecordList1);
            }
            
            //2.投资期限
            List<Long> investRecordIds2 = InvestRecordService.getIdsByDynamicCondition(InvestRecord.class, param2, 0, Integer.MAX_VALUE);
            List<InvestRecord> investRecordList2 = InvestRecordService.getObjectsByIds(investRecordIds2);
            if (investRecordList2 != null) {
                matchedList.addAll(investRecordList2);
            }
            
            
            model.addAttribute("code", 0);
            
            
            model.addAttribute("total", matchedList.size());
            
            model.addAttribute("investRecordList", matchedList);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get matchedList list error");
            // for test
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/investRecord/json/investRecordListJson";
    }
    
    
    /**
     * 投资匹配
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/debtorMatch/{id}", method = RequestMethod.POST)
    public String addDebtorMatchJson(@PathVariable Long id, ModelMap model, Long investRecordId) throws Exception {
        
        log.info("update debtorMatch : debtorId= " + id);
        DebtorMatch debtorMatch = new DebtorMatch();
        debtorMatch.setDebtorId(id);
        try {
            InvestRecord investRecord = InvestRecordService.getObjectById(investRecordId);
            User user = userService.getObjectById(investRecord.getUserId());
            debtorMatch.setId(null);
            debtorMatch.setComodatoNum(investRecord.getComodatoNum());
            debtorMatch.setIntercreditorAgreement(investRecord.getIntercreditorAgreement());
            debtorMatch.setProductName(investRecord.getProductName());
            debtorMatch.setName(user.getName());
            debtorMatch.setInvestAmount(investRecord.getInvestAmount());
            debtorMatch.setValueDay(investRecord.getValueDay());
            debtorMatch.setValueEndDay(investRecord.getValueEndDay());
            
            debtorMatchService.insert(debtorMatch);
            //更新该条投资记录
            investRecord.setMatched(1);
            InvestRecordService.update(investRecord);
            
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add debtorMatch error ");
            model.addAttribute("code", -6002);
        }
        
        return "/polyFinance-lgd-server/investRecord/json/investRecordListJson";
    }
    
    
    /**
     * 后台：获取债权匹配列表
     *
     * @param id               债权人id
     * @param productName      产品名称
     * @param name             用户名
     * @param valueDayStart    起息日起
     * @param valueDayEnd      起息日止
     * @param valueEndDayStart 到息日起
     * @param valueEndDayEnd   到息日止
     * @param page             页数
     * @param size             每页个数
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/debtorMatch/list", method = RequestMethod.GET)
    public String getMultiDebtorMatchJson(ModelMap model, Long id, String productName, String name, Long valueDayStart, Long valueDayEnd, Long valueEndDayStart, Long valueEndDayEnd, Integer page, Integer size) throws Exception {
        
        if (CommonUtil.isEmpty(id)) {
            model.addAttribute("code", -200);
            return "/polyFinance-lgd-server/debtorMatch/json/debtorMatchListJson";
        }
        
        Map<String, Object> param = DynamicUtil.getDebtorMatch(id, productName, name, valueDayStart, valueDayEnd, valueEndDayStart, valueEndDayEnd);
        
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
        
        try {
            List<Long> idList = debtorMatchService.getIdsByDynamicCondition(DebtorMatch.class, param, start, size);
            Integer total = debtorMatchService.getIdsByDynamicCondition(DebtorMatch.class, param, 0, Integer.MAX_VALUE).size();
            List<DebtorMatch> debtorMatchList = debtorMatchService.getObjectsByIds(idList);
            log.info("get  debtorMatch data is " + debtorMatchList);
            
            model.addAttribute("code", 0);
            model.addAttribute("total", total);
            
            model.addAttribute("debtorMatchList", debtorMatchList);
            
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get debtorMatch error");
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/debtorMatch/json/debtorMatchListJson";
    }
    
    
}

