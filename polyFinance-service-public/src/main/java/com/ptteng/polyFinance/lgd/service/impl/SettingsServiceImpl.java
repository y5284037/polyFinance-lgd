package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.Settings;
import com.ptteng.polyFinance.lgd.service.SettingsService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class SettingsServiceImpl extends BaseDaoServiceImpl implements SettingsService {

 

	private static final Log log = LogFactory.getLog(SettingsServiceImpl.class);



		   
		@Override
		public Long insert(Settings settings)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + settings);

		if (settings == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		settings.setCreateAt(currentTimeMillis);
		settings.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(settings);
		} catch (DaoException e) {
			log.error(" insert wrong : " + settings);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Settings> insertList(List<Settings> settingsList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (settingsList == null ? "null" : settingsList.size()));
      
		List<Settings> resultList = null;

		if (CollectionUtils.isEmpty(settingsList)) {
			return new ArrayList<Settings>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Settings settings : settingsList) {
			settings.setCreateAt(currentTimeMillis);
			settings.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Settings>) dao.batchSave(settingsList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + settingsList);
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
			result = dao.delete(Settings.class, id);
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
		public boolean update(Settings settings)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (settings == null ? "null" : settings.getId()));

		boolean result = false;

		if (settings == null) {
			return true;
		}

		settings.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(settings);
		} catch (DaoException e) {
			log.error(" update wrong : " + settings);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + settings);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Settings> settingsList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (settingsList == null ? "null" : settingsList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(settingsList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Settings settings : settingsList) {
			settings.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(settingsList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + settingsList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + settingsList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Settings getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Settings settings = null;

		if (id == null) {
			return settings;
		}

		try {
			settings = (Settings) dao.get(Settings.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return settings;		
		}	
		  
    	   
		@Override
		public List<Settings> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Settings> settings = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Settings>();
		}

		try {
			settings = (List<Settings>) dao.getList(Settings.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (settings == null ? "null" : settings.size()));
    
		return settings;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getSettingsIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getSettingsIdsAll",new Object[] {},start, limit, false);
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
	public Integer countSettingsIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getSettingsIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getSettingsIds " ) ;
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

