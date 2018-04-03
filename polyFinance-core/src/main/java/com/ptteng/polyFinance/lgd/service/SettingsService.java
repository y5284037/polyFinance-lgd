package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.Settings;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

@Remotable
@Service
public interface SettingsService extends BaseDaoService {

	



   		   
		
		public Long insert(Settings settings)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Settings> insertList(List<Settings> settingsList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Settings settings)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Settings> settingsList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Settings getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Settings> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getSettingsIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countSettingsIds() throws ServiceException, ServiceDaoException;
	

}

