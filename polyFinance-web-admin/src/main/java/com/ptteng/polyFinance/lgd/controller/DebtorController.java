package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.polyFinance.lgd.model.Debtor;
import com.ptteng.polyFinance.lgd.service.DebtorService;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Debtor  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class DebtorController {
    private static final Log log = LogFactory.getLog(DebtorController.class);
    
    @Autowired
    private DebtorService debtorService;
    
    /**
     * 后台：查询债权详情
     *
     * @param model
     * @param id    债权id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/debtor/{id}", method = RequestMethod.GET)
    public String getDebtorJson(ModelMap model, @PathVariable Long id) throws Exception {
        
        log.info("get data : id= " + id);
        try {
            Debtor debtor = debtorService.getObjectById(id);
            log.info("get debtor data is " + debtor);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("debtor", debtor);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get debtor error,id is  " + id);
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/debtor/json/debtorDetailJson";
    }
    
    
    /**
     * 后台：修改债权接口
     *
     * @param id     债权id
     * @param debtorD 债权对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/debtor/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateDebtorJson(@PathVariable Long id, Debtor debtorD) throws Exception {
        JSONObject a = new JSONObject();
        log.info("update debtor : debtor= " + debtorD);
        Debtor debtor = new Debtor();
        try {
            
            BeanUtils.copyProperties(debtorD,debtor);
            debtor.setId(id);
            debtorService.update(debtor);
            
            
            a.put("code", 0);
            a.put("message", "success");
            
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update debtor error,id is  " + debtor.getId());
            a.put("code", -100);
            a.put("messsge", "Server has something wrong");
            
        }
        
        return a.toString();
    }
    
    /**
     * 后台：新增债权接口
     *
     * @param model
     * @param debtor 债权信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/debtor", method = RequestMethod.POST)
    public String addDebtorJson(ModelMap model, Debtor debtor) throws Exception {
        
        log.info("insert debtor : debtor= " + debtor);
        
        try {
            debtor.setId(null);
            debtor.setMatchedAmount(new BigDecimal(0));
            debtorService.insert(debtor);
            
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add debtor error ");
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/debtor/json/debtorDetailJson";
    }
    
    /**
     * 后台 ： 债权列表
     *
     * @param model
     * @param debtorMark         债务人编号
     * @param debtorName         姓名
     * @param debtorPhone        手机号
     * @param debtorIDcard       债务人身份证号码
     * @param expiresStart       出借期限起
     * @param expiresEnd         出借期限止
     * @param debtStartTimeStart 出借日期起
     * @param debtStartTimeEnd   出借日期止
     * @param debtEndTimeStart   到期日期起
     * @param debtEndTimeEnd     到期日期止
     * @param amountStart        出借金额起
     * @param amountEnd          出借金额止
     * @param status
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/debtor/list", method = RequestMethod.GET)
    public String getMultiDebtorJson(ModelMap model, String debtorMark, String debtorName, String debtorPhone, String debtorIDcard, Integer expiresStart, Integer expiresEnd, Long debtStartTimeStart, Long debtStartTimeEnd, Long debtEndTimeStart, Long debtEndTimeEnd, BigDecimal amountStart, BigDecimal amountEnd, Integer status, Integer page, Integer size) throws Exception {
        
        Map<String, Object> param = DynamicUtil.getDebtorList(debtorMark, debtorName, debtorPhone, debtorIDcard, expiresStart, expiresEnd, debtStartTimeStart, debtStartTimeEnd, debtEndTimeStart, debtEndTimeEnd, amountStart, amountEnd, status);
        
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
            List<Long> idList = debtorService.getIdsByDynamicCondition(Debtor.class, param, start, size);
            
            List<Debtor> debtorList = debtorService.getObjectsByIds(idList);
            Integer total = debtorService.getIdsByDynamicCondition(Debtor.class, param, 0, Integer.MAX_VALUE).size();
            log.info("get  debtor data is " + debtorList);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("total", total);
            
            model.addAttribute("debtorList", debtorList);
            
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get debtor list error");
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/debtor/json/debtorListJson";
    }
    
    
}

