package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * 查询用户投资记录列表
     *
     * @param id       当前登录用户id
     * @param page     当前显示页数
     * @param size     每页数量
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/a/u/investRecord/list/{id}", method = RequestMethod.GET)
    public String getUserInverstRecord(@PathVariable Long id, Integer page, Integer size, ModelMap modelMap) {
        
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
            List<Long> ids = investRecordService.getInvestRecordIdsByUserIdOrderByCreateAt(id, start, size);
            List<InvestRecord> investRecords = investRecordService.getObjectsByIds(ids);
            modelMap.addAttribute("investRecordList", investRecords);
            modelMap.addAttribute("code", 0);
            modelMap.addAttribute("total", investRecordService.countInvestRecordIdsByUserIdOrderByCreateAt(id));
            modelMap.addAttribute("size", size);
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100000);
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
            modelMap.addAttribute("code", -100000);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/investRecord/json/investRecordDetailJson";
    }
}

