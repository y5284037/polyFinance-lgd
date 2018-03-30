package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.BankList;
import com.ptteng.polyFinance.lgd.service.BankListService;
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
 * BankList  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class BankListController {
    private static final Log log = LogFactory.getLog(BankListController.class);
    
    @Autowired
    private BankListService bankListService;
    
    
    /**
     * 查询平台可用银行卡列表
     *
     * @param model
     * @param page  页数
     * @param size  每页个数
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/bankList/list", method = RequestMethod.GET)
    public String getMultiBankListJson(ModelMap model, Integer page, Integer size)
            throws Exception {
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
        List<Long> ids = new ArrayList<>();
        try {
            ids = bankListService.getBankListIds(start, size);
            List<BankList> bankListList = bankListService.getObjectsByIds(ids);
            log.info("get  bankList data is " + bankListList);
            
            model.addAttribute("code", 0);
            model.addAttribute("total", bankListList.size());
            
            model.addAttribute("bankListList", bankListList);
            
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get bankList error,id is  " + ids);
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/bankList/json/bankListListJson";
    }
    
    
}

