package com.ptteng.polyFinance.lgd.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.polyFinance.lgd.model.Debtor;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import org.springframework.stereotype.Service;

@Service
@Remotable
public interface DebtorService extends BaseDaoService {

	



   		   
		
		public Long insert(Debtor debtor)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Debtor> insertList(List<Debtor> debtorList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Debtor debtor)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Debtor> debtorList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Debtor getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Debtor> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getDebtorIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countDebtorIds() throws ServiceException, ServiceDaoException;
	

}

