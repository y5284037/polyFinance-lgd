package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.UserMessage;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

@Remotable
@Service
public interface UserMessageService extends BaseDaoService {

	



   		   
		
		public Long insert(UserMessage userMessage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserMessage> insertList(List<UserMessage> userMessageList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UserMessage userMessage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UserMessage> userMessageList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UserMessage getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserMessage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countUserMessageIdsByUserIdAndMessageReadStatus(Long userId, Integer messageReadStatus)throws ServiceException, ServiceDaoException;
	
	
	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countUserMessageIdsByUserId(Long userId)throws ServiceException, ServiceDaoException;
	
	
	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getUserMessageIdsByUserIdAndMessageReadStatus(Long userId, Integer messageReadStatus, Integer start, Integer limit)throws ServiceException, ServiceDaoException;
	
	
	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getUserMessageIdsByUserId(Long userId, Integer start, Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserMessageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserMessageIds() throws ServiceException, ServiceDaoException;
	

}

