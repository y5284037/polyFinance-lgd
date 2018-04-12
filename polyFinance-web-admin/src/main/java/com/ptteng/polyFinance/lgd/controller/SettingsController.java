package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSON;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Settings;
import com.ptteng.polyFinance.lgd.service.SettingsService;
import com.ptteng.polyFinance.lgd.utils.JUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Settings  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class SettingsController {
    private static final Log log = LogFactory.getLog(SettingsController.class);
    
    @Autowired
    private SettingsService settingsService;
    
    
    /**
     * 参数设置详情
     *
     * @return
     */
    @RequestMapping(value = "/a/u/settings", method = RequestMethod.GET)
    public @ResponseBody
    JSON getSettings() {
        JSON json;
        try {
            Settings settings = settingsService.getObjectById(1L);
            json = JUtils.getJSON(0, "data", settings);
        } catch (ServiceException | ServiceDaoException e) {
            json = JUtils.getJSON(-100);
            e.printStackTrace();
        }
        return json;
    }
    
    /**
     * 修改参数设置
     *
     * @param settings
     * @return
     */
    @RequestMapping(value = "/a/u/settings", method = RequestMethod.PUT)
    public @ResponseBody
    JSON updateSettings(Settings settings) {
        JSON json;
        long time = System.currentTimeMillis();
        settings.setUpdateAt(time);
        try {
            Settings s1 = settingsService.getObjectById(1L);
            settings.setCreateAt(s1.getCreateAt());
            settings.setCreateBy(s1.getCreateBy());
            settings.setUpdateBy(7L);
            settings.setUpdateAt(time);
            settings.setId(1L);
            settings.setStatus(0);
            settingsService.update(settings);
            s1.setUpdateAt(time);
            s1.setStatus(1);
            s1.setId(2L);
            settingsService.update(s1);
            json = JUtils.getJSON(0);
        } catch (ServiceException | ServiceDaoException e) {
            json = JUtils.getJSON(-100);
            e.printStackTrace();
        }
        return json;
    }
    
    /**
     * 还原参数设置(只能在当前数据和上一次数据之间来回更换)
     *
     * @return
     */
    @RequestMapping(value = "/a/u/settings/back", method = RequestMethod.GET)
    public @ResponseBody
    JSON back() {
        JSON json;
        try {
            Settings s1 = settingsService.getObjectById(1L);
            Settings s2 = settingsService.getObjectById(2L);
            s1.setId(2L);
            s2.setId(1L);
            settingsService.update(s1);
            settingsService.update(s2);
            json = JUtils.getJSON(0);
        } catch (ServiceException | ServiceDaoException e) {
            json = JUtils.getJSON(-100);
            e.printStackTrace();
        }
        return json;
    }
}

