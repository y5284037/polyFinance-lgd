package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.Admin;
import com.ptteng.polyFinance.lgd.service.AdminService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;
import java.util.List;


public class AdminServiceImpl extends BaseDaoServiceImpl implements AdminService {
    
    
    private static final Log log = LogFactory.getLog(AdminServiceImpl.class);
    
    
    @Override
    public Long insert(Admin admin) throws ServiceException, ServiceDaoException {
        
        
        log.info(" insert data : " + admin);
        
        if (admin == null) {
            return null;
        }
        
        long currentTimeMillis = System.currentTimeMillis();
        admin.setCreateAt(currentTimeMillis);
        admin.setUpdateAt(currentTimeMillis);
        
        Long result = null;
        try {
            result = (Long) dao.save(admin);
        } catch (DaoException e) {
            log.error(" insert wrong : " + admin);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" insert data success : " + result);
        
        return result;
    }
    
    
    @Override
    public List<Admin> insertList(List<Admin> adminList) throws ServiceException, ServiceDaoException {
        
        
        log.info(" insert lists : " + (adminList == null ? "null" : adminList.size()));
        
        List<Admin> resultList = null;
        
        if (CollectionUtils.isEmpty(adminList)) {
            return new ArrayList<Admin>();
        }
        
        long currentTimeMillis = System.currentTimeMillis();
        for (Admin admin : adminList) {
            admin.setCreateAt(currentTimeMillis);
            admin.setUpdateAt(currentTimeMillis);
        }
        
        try {
            resultList = (List<Admin>) dao.batchSave(adminList);
        } catch (DaoException e) {
            log.error(" insert list wrong : " + adminList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
        
        return resultList;
        
        
    }
    
    
    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {
        
        
        log.info(" delete data : " + id);
        
        boolean result = false;
        
        if (id == null) {
            return true;
        }
        
        try {
            result = dao.delete(Admin.class, id);
        } catch (DaoException e) {
            log.error(" delete wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" delete data success : " + id);
        
        return result;
        
    }
    
    
    @Override
    public boolean update(Admin admin) throws ServiceException, ServiceDaoException {
        
        
        log.info(" update data : " + (admin == null ? "null" : admin.getId()));
        
        boolean result = false;
        
        if (admin == null) {
            return true;
        }
        
        admin.setUpdateAt(System.currentTimeMillis());
        
        try {
            result = dao.update(admin);
        } catch (DaoException e) {
            log.error(" update wrong : " + admin);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" update data success : " + admin);
        }
        return result;
    }
    
    
    @Override
    public boolean updateList(List<Admin> adminList) throws ServiceException, ServiceDaoException {
        
        
        log.info(" update lists : " + (adminList == null ? "null" : adminList.size()));
        
        boolean result = false;
        
        if (CollectionUtils.isEmpty(adminList)) {
            return true;
        }
        
        long currentTimeMillis = System.currentTimeMillis();
        for (Admin admin : adminList) {
            admin.setUpdateAt(currentTimeMillis);
        }
        
        try {
            result = dao.batchUpdate(adminList);
        } catch (DaoException e) {
            log.error(" update list wrong : " + adminList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" update lists success : " + adminList.size());
        
        return result;
    }
    
    
    @Override
    public Admin getObjectById(Long id) throws ServiceException, ServiceDaoException {
        
        
        log.info(" get data : " + id);
        
        Admin admin = null;
        
        if (id == null) {
            return admin;
        }
        
        try {
            admin = (Admin) dao.get(Admin.class, id);
        } catch (DaoException e) {
            log.error(" get wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" get data success : " + id);
        
        return admin;
    }
    
    
    @Override
    public List<Admin> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {
        
        
        log.info(" get lists : " + (ids == null ? "null" : ids));
        
        List<Admin> admin = null;
        
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<Admin>();
        }
        
        try {
            admin = (List<Admin>) dao.getList(Admin.class, ids);
        } catch (DaoException e) {
            log.error(" get wrong : " + ids);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" get data success : " + (admin == null ? "null" : admin.size()));
        
        return admin;
    }
    
    @Override
    public Admin getObjectByLoginName(String loginName) throws ServiceException, ServiceDaoException {
        log.info("get admin by lgoinName");
        Long id = null;
        Admin admin = null;
        if (loginName == null) {
            loginName = "";
        }
        try {
            id =(Long)dao.getMapping("getObjectByLoginName",loginName);
            admin = getObjectById(id);
        } catch (DaoException e) {
            log.error("get id wrong by loginName :"+loginName);
            e.printStackTrace();
        }
        if(log.isInfoEnabled()){
            log.info("get id success: "+ id);
        }
        return admin;
    }

    @Override
    public List<Long> getAdminIds(Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        
        log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
        List<Long> idList = null;
        
        
        if (start == null) {
            start = 0;
        }
        
        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }
        
        try {
            idList = dao.getIdList("getAdminIdsAll", new Object[]{}, start, limit, false);
        } catch (DaoException e) {
            log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
        }
        return idList;
    }
    
    
    @Override
    public Integer countAdminIds() throws ServiceException,
            ServiceDaoException {
        Integer count = 0;
        try {
            count = dao.count("getAdminIdsAll", new Object[]{});
        } catch (DaoException e) {
            log.error(" count by getAdminIds ");
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" count  : " + count);
        }
        return count;
    }
    
}

