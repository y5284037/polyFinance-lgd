package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.DebtorMatch;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Remotable
public interface DebtorMatchService extends BaseDaoService {

	



   		   
		
		public Long insert(DebtorMatch debtorMatch)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DebtorMatch> insertList(List<DebtorMatch> debtorMatchList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(DebtorMatch debtorMatch)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<DebtorMatch> debtorMatchList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public DebtorMatch getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<DebtorMatch> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countDebtorMatchIdsByDebtorId(Long debtorId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getDebtorMatchIdsByDebtorId(Long debtorId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getDebtorMatchIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countDebtorMatchIds() throws ServiceException, ServiceDaoException;
	

}

