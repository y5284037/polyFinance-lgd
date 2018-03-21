package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.AdminRole;
import com.ptteng.polyFinance.lgd.service.AdminRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class AdminRoleServiceImpl extends BaseDaoServiceImpl implements AdminRoleService {

 

	private static final Log log = LogFactory.getLog(AdminRoleServiceImpl.class);



		   
		@Override
		public Long insert(AdminRole adminRole)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + adminRole);

		if (adminRole == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		adminRole.setCreateAt(currentTimeMillis);
		adminRole.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(adminRole);
		} catch (DaoException e) {
			log.error(" insert wrong : " + adminRole);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<AdminRole> insertList(List<AdminRole> adminRoleList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (adminRoleList == null ? "null" : adminRoleList.size()));
      
		List<AdminRole> resultList = null;

		if (CollectionUtils.isEmpty(adminRoleList)) {
			return new ArrayList<AdminRole>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AdminRole adminRole : adminRoleList) {
			adminRole.setCreateAt(currentTimeMillis);
			adminRole.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<AdminRole>) dao.batchSave(adminRoleList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + adminRoleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(AdminRole.class, id);
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
		public boolean update(AdminRole adminRole)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (adminRole == null ? "null" : adminRole.getId()));

		boolean result = false;

		if (adminRole == null) {
			return true;
		}

		adminRole.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(adminRole);
		} catch (DaoException e) {
			log.error(" update wrong : " + adminRole);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + adminRole);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<AdminRole> adminRoleList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (adminRoleList == null ? "null" : adminRoleList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(adminRoleList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (AdminRole adminRole : adminRoleList) {
			adminRole.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(adminRoleList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + adminRoleList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + adminRoleList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public AdminRole getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		AdminRole adminRole = null;

		if (id == null) {
			return adminRole;
		}

		try {
			adminRole = (AdminRole) dao.get(AdminRole.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return adminRole;		
		}	
		  
    	   
		@Override
		public List<AdminRole> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<AdminRole> adminRole = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<AdminRole>();
		}

		try {
			adminRole = (List<AdminRole>) dao.getList(AdminRole.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (adminRole == null ? "null" : adminRole.size()));
    
		return adminRole;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getAdminRoleIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getAdminRoleIdsAll",new Object[] {},start, limit, false);
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
	public Integer countAdminRoleIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getAdminRoleIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getAdminRoleIds " ) ;
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

