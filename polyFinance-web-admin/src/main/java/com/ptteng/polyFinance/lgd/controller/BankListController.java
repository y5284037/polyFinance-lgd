package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.polyFinance.lgd.model.Admin;
import com.ptteng.polyFinance.lgd.model.BankList;
import com.ptteng.polyFinance.lgd.service.AdminService;
import com.ptteng.polyFinance.lgd.service.BankListService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import com.ptteng.polyFinance.lgd.utils.FilesUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private AdminService adminService;
    
    /**
     * 后台：查询银行列表
     *
     * @param name                        银行名称
     * @param updateBy                    创建者
     * @param updateAtStart               更新时间起
     * @param updateAtEnd                 更新时间止
     * @param singleTransactionLimitStart 单笔限额起
     * @param singleTransactionLimitEnd   单笔限额止
     * @param dailyLimitStart             单日限额起
     * @param dailyLimitEnd               单日限额止
     * @param page                        页数
     * @param size                        每页个数
     * @param model
     * @return
     */
    @RequestMapping(value = "/a/u/bankList/list", method = RequestMethod.GET)
    public String getBankListListJson(String name, String updateBy, Long updateAtStart, Long updateAtEnd, String singleTransactionLimitStart, String singleTransactionLimitEnd, String dailyLimitStart, String dailyLimitEnd, Integer page, Integer size, ModelMap model) {
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
        
        Map<String, Object> param = DynamicUtil.getBanklistList(name, updateBy, updateAtStart, updateAtEnd, singleTransactionLimitStart, singleTransactionLimitEnd, dailyLimitStart, dailyLimitEnd);
        log.info("DynamicCondition SQL : getBanklistListsql " + SQLUtil.convert2Sql(param, start, size));
        
        try {
            List<Long> ids = bankListService.getIdsByDynamicCondition(BankList.class, param, start, size);
            List<BankList> bankLists = bankListService.getObjectsByIds(ids);
            
            Integer total = bankListService.countBankListIds();
            
            
            model.addAttribute("code", 0);
            model.addAttribute("total", total);
            model.addAttribute("size", size);
            model.addAttribute("bankListList", bankLists);
            
        } catch (Throwable e) {
            log.info(e.getMessage());
            log.info("get bankList list error");
            e.printStackTrace();
            model.addAttribute("code", -100);
        }
        return "/polyFinance-lgd-server/bankList/json/bankListListJson";
    }
    
    /**
     * 后台：查询银行详情
     *
     * @param model
     * @param id    用户id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/bankList/{id}", method = RequestMethod.GET)
    public String getBankListJson(ModelMap model, @PathVariable Long id)
            throws Exception {
        log.info("get data : id= " + id);
        try {
            BankList bankList = bankListService.getObjectById(id);
            if (bankList == null) {
                model.addAttribute("code", -200);
                return "/polyFinance-lgd-server/bankList/json/bankListDetailJson";
            }
            String url = FilesUtil.getUrl(bankList.getLogoPic());
            bankList.setLogoPic(url);
            
            log.info("get bankList data is " + bankList);
            model.addAttribute("code", 0);
            model.addAttribute("bankList", bankList);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get bankList error,id is  " + id);
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/bankList/json/bankListDetailJson";
    }
    
    /**
     * 后台：修改银行接口
     *
     * @param id                     银行id
     * @param name                   银行名
     * @param paymentAgencyNumber    支付机构号
     * @param withdrawAgencyNumber   提现机构号
     * @param singleTransactionLimit 单笔限额
     * @param dailyLimit             日累计限额
     * @param logoPic                ICON
     * @param adminId                管理员
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/bankList/{id}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateBankListJson(@PathVariable Long id, String name, String paymentAgencyNumber, String withdrawAgencyNumber, String singleTransactionLimit, String dailyLimit, MultipartFile logoPic, Long adminId) throws Exception {
        JSONObject a = new JSONObject();
        if (CommonUtil.isEmpty(id, name, paymentAgencyNumber, withdrawAgencyNumber, singleTransactionLimit, dailyLimit)) {
            a.put("code", -200);
            a.put("message", "necessary param wrong");
            return a.toString();
        }
        
        log.info("update bankList : bankList= " + name);
        BankList bankList;
        
        try {
            bankList = bankListService.getObjectById(id);
            if (bankList == null) {
                a.put("code", -200);
                a.put("message", "necessary param wrong");
                return a.toString();
            }
            if (logoPic != null && logoPic.getSize() > 0) {
                String url = FilesUtil.upLoadFile(logoPic);
                bankList.setLogoPic(url);
            }
            bankList.setName(name);
            bankList.setId(id);
            bankList.setDailyLimit(dailyLimit);
            bankList.setPaymentAgencyNumber(paymentAgencyNumber);
            bankList.setWithdrawAgencyNumber(withdrawAgencyNumber);
            bankList.setSingleTransactionLimit(singleTransactionLimit);
            bankList.setUpdateAt(System.currentTimeMillis());
            
            Admin admin = adminService.getObjectById(adminId);
            if (admin != null) {
                bankList.setUpdateBy(admin.getLoginName());
            }
            bankListService.update(bankList);
            
            a.put("code", 0);
            a.put("message", "success");
            
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update bankList error,id is  " + id);
            
            a.put("code", -100);
            a.put("message", "Server has something wrong");
        }
        
        return a.toString();
    }
    
    /**
     * 后台：新增银行接口
     *
     * @param name                   银行名
     * @param paymentAgencyNumber    支付机构号
     * @param withdrawAgencyNumber   提现机构号
     * @param singleTransactionLimit 单笔限额
     * @param dailyLimit             日累计限额
     * @param logoPic                ICON
     * @param adminId                管理员
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/bankList", method = RequestMethod.POST)
    @ResponseBody
    public String addBankListJson(String name, String paymentAgencyNumber, String withdrawAgencyNumber, String singleTransactionLimit, String dailyLimit, MultipartFile logoPic, Long adminId) throws Exception {
        
        JSONObject a = new JSONObject();
        if (CommonUtil.isEmpty(name, paymentAgencyNumber, withdrawAgencyNumber, singleTransactionLimit, dailyLimit)) {
            a.put("code", -200);
            a.put("message", "necessary param wrong");
            return a.toString();
        }
        log.info("insert bankList : bankList= " + name);
        BankList bankList = new BankList();
        
        try {
            
            if (logoPic != null && logoPic.getSize() > 0) {
                String url = FilesUtil.upLoadFile(logoPic);
                bankList.setLogoPic(url);
            }
            bankList.setId(null);
            bankList.setName(name);
            bankList.setDailyLimit(dailyLimit);
            bankList.setPaymentAgencyNumber(paymentAgencyNumber);
            bankList.setWithdrawAgencyNumber(withdrawAgencyNumber);
            bankList.setSingleTransactionLimit(singleTransactionLimit);
            bankList.setUpdateAt(System.currentTimeMillis());
            
            Admin admin = adminService.getObjectById(adminId);
            if (admin != null) {
                bankList.setUpdateBy(admin.getLoginName());
                bankList.setCreateBy(admin.getLoginName());
            }
            bankListService.insert(bankList);
            
            a.put("code", 0);
            a.put("message", "success");
            
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("insert bankList error");
            
            a.put("code", -100);
            a.put("message", "Server has something wrong");
            return a.toString();
        }
        
        return a.toString();
    }
    
    /**
     * 删除银行接口
     *
     * @param id 用户id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/bankList/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBankListJson1(@PathVariable Long id)
            throws Exception {
        JSONObject a = new JSONObject();
        log.info("delete bankList : id= " + id);
        try {
            String path = bankListService.getObjectById(id).getLogoPic();
            boolean flag = bankListService.delete(id);
            if (flag) {
                FilesUtil.deleteObject(path);
                log.info("delete bankList success");
                a.put("code", 0);
                a.put("message", "success");
            }
            
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete bankList error,id is  " + id);
            a.put("code", -100);
            a.put("message", "Server has something wrong");
            
        }
        return a.toString();
    }
    
    
}

