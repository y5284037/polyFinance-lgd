package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.Authority;
import com.ptteng.polyFinance.lgd.service.AuthorityService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class AuthorityServiceImpl extends BaseDaoServiceImpl implements AuthorityService {
    
    
    private static final Log log = LogFactory.getLog(AuthorityServiceImpl.class);
    
    
    @Override
    public Long insert(Authority authority) throws ServiceException, ServiceDaoException {
        
        
        log.info(" insert data : " + authority);
        
        if (authority == null) {
            return null;
        }
        
        long currentTimeMillis = System.currentTimeMillis();
        authority.setCreateAt(currentTimeMillis);
        authority.setUpdateAt(currentTimeMillis);
        
        Long result = null;
        try {
            result = (Long) dao.save(authority);
        } catch (DaoException e) {
            log.error(" insert wrong : " + authority);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" insert data success : " + result);
        
        return result;
    }
    
    
    @Override
    public List<Authority> insertList(List<Authority> authorityList) throws ServiceException, ServiceDaoException {
        
        
        log.info(" insert lists : " + (authorityList == null ? "null" : authorityList.size()));
        
        List<Authority> resultList = null;
        
        if (CollectionUtils.isEmpty(authorityList)) {
            return new ArrayList<Authority>();
        }
        
        long currentTimeMillis = System.currentTimeMillis();
        for (Authority authority : authorityList) {
            authority.setCreateAt(currentTimeMillis);
            authority.setUpdateAt(currentTimeMillis);
        }
        
        try {
            resultList = (List<Authority>) dao.batchSave(authorityList);
        } catch (DaoException e) {
            log.error(" insert list wrong : " + authorityList);
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
            result = dao.delete(Authority.class, id);
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
    public boolean update(Authority authority) throws ServiceException, ServiceDaoException {
        
        
        log.info(" update data : " + (authority == null ? "null" : authority.getId()));
        
        boolean result = false;
        
        if (authority == null) {
            return true;
        }
        
        authority.setUpdateAt(System.currentTimeMillis());
        
        try {
            result = dao.update(authority);
        } catch (DaoException e) {
            log.error(" update wrong : " + authority);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" update data success : " + authority);
        }
        return result;
    }
    
    
    @Override
    public boolean updateList(List<Authority> authorityList) throws ServiceException, ServiceDaoException {
        
        
        log.info(" update lists : " + (authorityList == null ? "null" : authorityList.size()));
        
        boolean result = false;
        
        if (CollectionUtils.isEmpty(authorityList)) {
            return true;
        }
        
        long currentTimeMillis = System.currentTimeMillis();
        for (Authority authority : authorityList) {
            authority.setUpdateAt(currentTimeMillis);
        }
        
        try {
            result = dao.batchUpdate(authorityList);
        } catch (DaoException e) {
            log.error(" update list wrong : " + authorityList);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" update lists success : " + authorityList.size());
        
        return result;
    }
    
    
    @Override
    public Authority getObjectById(Long id) throws ServiceException, ServiceDaoException {
        
        
        log.info(" get data : " + id);
        
        Authority authority = null;
        
        if (id == null) {
            return authority;
        }
        
        try {
            authority = (Authority) dao.get(Authority.class, id);
        } catch (DaoException e) {
            log.error(" get wrong : " + id);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" get data success : " + id);
        
        return authority;
    }
    
    
    @Override
    public List<Authority> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {
        
        
        log.info(" get lists : " + (ids == null ? "null" : ids));
        
        List<Authority> authority = null;
        
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<Authority>();
        }
        
        try {
            authority = (List<Authority>) dao.getList(Authority.class, ids);
        } catch (DaoException e) {
            log.error(" get wrong : " + ids);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        
        log.info(" get data success : " + (authority == null ? "null" : authority.size()));
        
        return authority;
    }
    
    
    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public List<Long> getAuthorityIdsByAdminRoleId(Long adminRoleId, Integer start, Integer limit) throws ServiceException, ServiceDaoException {
        
        if (log.isInfoEnabled()) {
            log.info(" get ids by adminRoleId,start,limit  : " + adminRoleId + " , " + start + " , " + limit);
        }
        List<Long> idList = null;
        
        // TODO 参数检查!
        
        if (start == null) {
            start = 0;
        }
        
        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }
        
        try {
            idList = dao.getIdList("getAuthorityIdsByAdminRoleId", new Object[]{adminRoleId}, start, limit, false);
            
            
        } catch (DaoException e) {
            log.error(" get ids  wrong by adminRoleId,start,limit)  : " + adminRoleId + " , " + start + " , " + limit);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
        }
        return idList;
        
        
    }
    
    
    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    @Override
    public Integer countAuthorityIdsByAdminRoleId(Long adminRoleId) throws ServiceException, ServiceDaoException {
        
        if (log.isInfoEnabled()) {
            log.info(" count ids by adminRoleId  : " + adminRoleId);
        }
        Integer count = null;
        
        
        try {
            
            count = dao.count("getAuthorityIdsByAdminRoleId", new Object[]{adminRoleId});
            
            
        } catch (DaoException e) {
            log.error(" count ids  wrong by adminRoleId)  : " + adminRoleId);
            log.error(e);
            e.printStackTrace();
            throw new ServiceDaoException(e);
        }
        if (log.isInfoEnabled()) {
            log.info(" count  success : " + count);
        }
        return count;
        
        
    }
    
    
    @Override
    public List<Long> getAuthorityIds(Integer start, Integer limit)
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
            idList = dao.getIdList("getAuthorityIdsAll", new Object[]{}, start, limit, false);
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
    public Integer countAuthorityIds() throws ServiceException,
            ServiceDaoException {
        Integer count = 0;
        try {
            count = dao.count("getAuthorityIdsAll", new Object[]{});
        } catch (DaoException e) {
            log.error(" count by getAuthorityIds ");
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

