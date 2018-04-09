package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.BankList;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

@Remotable
@Service
public interface BankListService extends BaseDaoService {

	



   		   
		
		public Long insert(BankList bankList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<BankList> insertList(List<BankList> bankListList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(BankList bankList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<BankList> bankListList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public BankList getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<BankList> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getBankListIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countBankListIds() throws ServiceException, ServiceDaoException;
	

}

