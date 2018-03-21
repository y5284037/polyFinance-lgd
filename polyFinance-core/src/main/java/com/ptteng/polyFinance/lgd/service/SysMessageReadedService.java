package com.ptteng.polyFinance.lgd.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.polyFinance.lgd.model.SysMessageReaded;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface SysMessageReadedService extends BaseDaoService {

	



   		   
		
		public Long insert(SysMessageReaded sysMessageReaded)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<SysMessageReaded> insertList(List<SysMessageReaded> sysMessageReadedList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(SysMessageReaded sysMessageReaded)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<SysMessageReaded> sysMessageReadedList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public SysMessageReaded getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<SysMessageReaded> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countSysMessageReadedIdsByUserId(Long userId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getSysMessageReadedIdsByUserId(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getSysMessageReadedIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countSysMessageReadedIds() throws ServiceException, ServiceDaoException;
	

}

