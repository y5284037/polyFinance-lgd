package com.ptteng.polyFinance.lgd.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.polyFinance.lgd.model.Repayment;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import org.springframework.stereotype.Service;

@Remotable
@Service
public interface RepaymentService extends BaseDaoService {

	



   		   
		
		public Long insert(Repayment repayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Repayment> insertList(List<Repayment> repaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Repayment repayment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Repayment> repaymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Repayment getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Repayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countRepaymentIdsByRepaymentStatus(Integer repaymentStatus)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getRepaymentIdsByRepaymentStatus(Integer repaymentStatus,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getRepaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countRepaymentIds() throws ServiceException, ServiceDaoException;
	

}

