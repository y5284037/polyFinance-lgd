package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.Debtor;
import com.ptteng.polyFinance.lgd.service.DebtorService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class DebtorServiceImpl extends BaseDaoServiceImpl implements DebtorService {

 

	private static final Log log = LogFactory.getLog(DebtorServiceImpl.class);



		   
		@Override
		public Long insert(Debtor debtor)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + debtor);

		if (debtor == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		debtor.setCreateAt(currentTimeMillis);
		debtor.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(debtor);
		} catch (DaoException e) {
			log.error(" insert wrong : " + debtor);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Debtor> insertList(List<Debtor> debtorList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (debtorList == null ? "null" : debtorList.size()));
      
		List<Debtor> resultList = null;

		if (CollectionUtils.isEmpty(debtorList)) {
			return new ArrayList<Debtor>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Debtor debtor : debtorList) {
			debtor.setCreateAt(currentTimeMillis);
			debtor.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Debtor>) dao.batchSave(debtorList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + debtorList);
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
			result = dao.delete(Debtor.class, id);
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
		public boolean update(Debtor debtor)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (debtor == null ? "null" : debtor.getId()));

		boolean result = false;

		if (debtor == null) {
			return true;
		}

		debtor.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(debtor);
		} catch (DaoException e) {
			log.error(" update wrong : " + debtor);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + debtor);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Debtor> debtorList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (debtorList == null ? "null" : debtorList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(debtorList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Debtor debtor : debtorList) {
			debtor.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(debtorList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + debtorList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + debtorList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Debtor getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Debtor debtor = null;

		if (id == null) {
			return debtor;
		}

		try {
			debtor = (Debtor) dao.get(Debtor.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return debtor;		
		}	
		  
    	   
		@Override
		public List<Debtor> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Debtor> debtor = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Debtor>();
		}

		try {
			debtor = (List<Debtor>) dao.getList(Debtor.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (debtor == null ? "null" : debtor.size()));
    
		return debtor;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getDebtorIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDebtorIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDebtorIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDebtorIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDebtorIds " ) ;
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

