package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.SysMessage;
import com.ptteng.polyFinance.lgd.service.SysMessageService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * SysMessage  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class SysMessageController {
    private static final Log log = LogFactory.getLog(SysMessageController.class);
    
    @Autowired
    private SysMessageService sysMessageService;
    
    @RequestMapping(value = "/a/u/sysMessage/list", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getsysList(String title, String updateBy, Long updateAtStart, Long updateAtEnd, Integer status, Integer sendTo, Integer page, Integer size) {
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
        Map<String, Object> json = new HashMap<>();
        Map<String, Object> map = DynamicUtil.getSysMessageSql(title, updateBy, updateAtStart, updateAtEnd, status, sendTo);
        try {
            List<Long> ids = sysMessageService.getIdsByDynamicCondition(SysMessage.class, map, start, size);
            List<SysMessage> list = sysMessageService.getObjectsByIds(ids);
            json.put("sysMessageList", list);
            json.put("code", 0);
            json.put("total", sysMessageService.getIdsByDynamicCondition(SysMessage.class, map, 0, Integer.MAX_VALUE));
            json.put("size", size);
        } catch (Throwable e) {
            json.put("code", -100);
            e.printStackTrace();
        }
        return json;
    }
}

