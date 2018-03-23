package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.polyFinance.lgd.model.TradingRecord;
import com.ptteng.polyFinance.lgd.service.TradingRecordService;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
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
import java.util.Map;

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
     * 后台:查询用户交易记录列表
     *
     * @param model
     * @param userId         用户id
     * @param productName    产品名称
     * @param tradingType    交易类型
     * @param tradeDateStart 交易日期起
     * @param tradeDateEnd   交易日期止
     * @param tradingStatus  交易状态
     * @param page           页数
     * @param size           每页个数
     * @return
     */
    @RequestMapping(value = "/a/u/tradingRecord/list", method = RequestMethod.GET)
    public String getUserTradingRecord(ModelMap model, Long userId, String productName, String tradingType, String tradeDateStart, String tradeDateEnd, String tradingStatus, Integer page, Integer size) {
        Map<String, Object> param = DynamicUtil.getUserTradingRecord(userId, productName, tradingType, tradeDateStart, tradeDateEnd, tradingStatus);
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
        log.info("DynamicCondition SQL : getUserTradingRecord---->>> " + SQLUtil.convert2Sql(param, start, size));
        
        try {
            List<Long> ids = tradingRecordService.getIdsByDynamicCondition(TradingRecord.class, param, start, size);
            List<TradingRecord> tradingRecordList = tradingRecordService.getObjectsByIds(ids);
            List<Long> countIds = tradingRecordService.getIdsByDynamicCondition(TradingRecord.class, param, 0, tradingRecordService.countTradingRecordIds());
            Integer total = countIds.size();
            model.addAttribute("code", 0);
            model.addAttribute("total", total);
            model.addAttribute("tradingRecordList", tradingRecordList);
            
        } catch (Throwable e) {
            log.error(e);
            log.error("getUserTradingRecord error , page is  " + start + " , size ");
            model.addAttribute("code", -100000);
            e.printStackTrace();
        }
        return "/polyFinance-lgd-server/tradingRecord/json/tradingRecordListJson";
    }
    
    
}

