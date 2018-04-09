package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.SysMessage;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

@Remotable
@Service
public interface SysMessageService extends BaseDaoService {

	



   		   
		
		public Long insert(SysMessage sysMessage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<SysMessage> insertList(List<SysMessage> sysMessageList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(SysMessage sysMessage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<SysMessage> sysMessageList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public SysMessage getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<SysMessage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countSysMessageIdsByStatus(Integer status)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getSysMessageIdsByStatus(Integer status,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getSysMessageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countSysMessageIds() throws ServiceException, ServiceDaoException;
	

}

