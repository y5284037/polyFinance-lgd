package com.ptteng.polyFinance.lgd.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.polyFinance.lgd.model.User;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Remotable
@Service
public interface UserService extends BaseDaoService {

	



   		   
		
		public Long insert(User user)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<User> insertList(List<User> userList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(User user)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<User> userList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public User getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<User> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
		
    	public User getObjectByPhoneNum(String phoneNum) throws ServiceException ,ServiceDaoException;
    	
    	
    	public void updateUserSerialNumById(Long id) throws ServiceException ,ServiceDaoException;
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserIds() throws ServiceException, ServiceDaoException;
	
	
	

}

