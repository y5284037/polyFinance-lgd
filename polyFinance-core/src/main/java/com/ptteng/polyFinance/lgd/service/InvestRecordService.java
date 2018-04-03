package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.InvestRecord;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Remotable
public interface InvestRecordService extends BaseDaoService {

	



   		   
		
		public Long insert(InvestRecord investRecord)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<InvestRecord> insertList(List<InvestRecord> investRecordList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(InvestRecord investRecord)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<InvestRecord> investRecordList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public InvestRecord getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<InvestRecord> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(Long userId,Integer investStatus)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countInvestRecordIdsByProductId(Long productId)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countInvestRecordIdsByUserIdOrderByCreateAt(Long userId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(Long userId,Integer investStatus,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getInvestRecordIdsByProductId(Long productId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getInvestRecordIdsByUserIdOrderByCreateAt(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getInvestRecordIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countInvestRecordIds() throws ServiceException, ServiceDaoException;
	

}

