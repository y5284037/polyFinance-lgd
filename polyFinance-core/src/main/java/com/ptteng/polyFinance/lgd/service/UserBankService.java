package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.UserBank;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

@Remotable
@Service
public interface UserBankService extends BaseDaoService {

	



   		   
		
		public Long insert(UserBank userBank)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserBank> insertList(List<UserBank> userBankList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(UserBank userBank)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<UserBank> userBankList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public UserBank getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<UserBank> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countUserBankIdsByUserId(Long userId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Long  getUserBankIdByUserIdAndFirst(Long userId, Integer first)throws ServiceException, ServiceDaoException;
	
	
	/**
	 *
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getUserBankIdsByUserId(Long userId, Integer start, Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserBankIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserBankIds() throws ServiceException, ServiceDaoException;
	

}

