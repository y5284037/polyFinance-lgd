package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.polyFinance.lgd.model.TradingRecord;
import com.ptteng.polyFinance.lgd.service.TradingRecordService;
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
 * TradingRecord  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class TradingRecordController {
    private static final Log log = LogFactory.getLog(TradingRecordController.class);
    
    @Autowired
    private TradingRecordService tradingRecordService;
    
    
    /**
     * 前台：查询用户交易流水列表
     *
     * @param id    用户id
     * @param model
     * @param page  页数
     * @param size  每页个数
     * @return
     */
    @RequestMapping(value = "/a/u/tradingRecord/list/{id}", method = RequestMethod.GET)
    public String getTradingRecordByUserId(@PathVariable("id") Long id, ModelMap model, Integer page, Integer size) {
        
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
        
        try {
            List<Long> ids = tradingRecordService.getTradingRecordIdsByUserIdOrderByTradingTime(id, start, size);
            List<TradingRecord> list = tradingRecordService.getObjectsByIds(ids);
            Integer total = tradingRecordService.countTradingRecordIdsByUserIdOrderByTradingTime(id);
            model.addAttribute("code", 0);
            model.addAttribute("size", size);
            model.addAttribute("total", total);
            model.addAttribute("tradingRecordList", list);
        } catch (Throwable e) {
            log.error(e);
            log.error("getUserTradingRecord error , page is  " + start + " , size ");
            model.addAttribute("code", -100000);
            e.printStackTrace();
        }
        return "/polyFinance-lgd-server/tradingRecord/json/tradingRecordListJson";
        
    }
    
    
    /**
     * 前台：用户交易流水详情
     *
     * @param model
     * @param id 用户id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/tradingRecord/{id}", method = RequestMethod.GET)
    public String getTradingRecordJson(ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("get data : id= " + id);
        try {
            TradingRecord tradingRecord = tradingRecordService.getObjectById(id);
            log.info("get tradingRecord data is " + tradingRecord);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("tradingRecord", tradingRecord);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get tradingRecord error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/tradingRecord/json/tradingRecordDetailJson";
    }
    
    
}

