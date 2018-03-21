package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.Repayment;
import com.ptteng.polyFinance.lgd.service.RepaymentService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class RepaymentServiceImpl extends BaseDaoServiceImpl implements RepaymentService {

 

	private static final Log log = LogFactory.getLog(RepaymentServiceImpl.class);



		   
		@Override
		public Long insert(Repayment repayment)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + repayment);

		if (repayment == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		repayment.setCreateAt(currentTimeMillis);
		repayment.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(repayment);
		} catch (DaoException e) {
			log.error(" insert wrong : " + repayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Repayment> insertList(List<Repayment> repaymentList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (repaymentList == null ? "null" : repaymentList.size()));
      
		List<Repayment> resultList = null;

		if (CollectionUtils.isEmpty(repaymentList)) {
			return new ArrayList<Repayment>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Repayment repayment : repaymentList) {
			repayment.setCreateAt(currentTimeMillis);
			repayment.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Repayment>) dao.batchSave(repaymentList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + repaymentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Repayment.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(Repayment repayment)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (repayment == null ? "null" : repayment.getId()));

		boolean result = false;

		if (repayment == null) {
			return true;
		}

		repayment.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(repayment);
		} catch (DaoException e) {
			log.error(" update wrong : " + repayment);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + repayment);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Repayment> repaymentList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (repaymentList == null ? "null" : repaymentList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(repaymentList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Repayment repayment : repaymentList) {
			repayment.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(repaymentList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + repaymentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + repaymentList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Repayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Repayment repayment = null;

		if (id == null) {
			return repayment;
		}

		try {
			repayment = (Repayment) dao.get(Repayment.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return repayment;		
		}	
		  
    	   
		@Override
		public List<Repayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Repayment> repayment = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Repayment>();
		}

		try {
			repayment = (List<Repayment>) dao.getList(Repayment.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (repayment == null ? "null" : repayment.size()));
    
		return repayment;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getRepaymentIdsByRepaymentStatus(Integer repaymentStatus,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by repaymentStatus,start,limit  : " + repaymentStatus+" , "+start+" , "+limit );
	  }
	 	List<Long> idList = null;
        
        // TODO 参数检查!

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

	try {
		idList = dao.getIdList("getRepaymentIdsByRepaymentStatus", new Object[] { repaymentStatus},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by repaymentStatus,start,limit)  : " + repaymentStatus+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
  }
		return idList;
		
	
	
	}
	
		
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countRepaymentIdsByRepaymentStatus(Integer repaymentStatus)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by repaymentStatus  : " + repaymentStatus );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getRepaymentIdsByRepaymentStatus", new Object[] { repaymentStatus});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by repaymentStatus)  : " + repaymentStatus );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
    log.info(" count  success : " + count);
  }
		return count;
		
	
	
	}
	
		
	
	
	
		
	@Override
	public List<Long> getRepaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getRepaymentIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countRepaymentIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getRepaymentIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getRepaymentIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

