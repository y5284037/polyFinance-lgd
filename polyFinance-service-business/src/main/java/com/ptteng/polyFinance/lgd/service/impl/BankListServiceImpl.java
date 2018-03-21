package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.BankList;
import com.ptteng.polyFinance.lgd.service.BankListService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class BankListServiceImpl extends BaseDaoServiceImpl implements BankListService {

 

	private static final Log log = LogFactory.getLog(BankListServiceImpl.class);



		   
		@Override
		public Long insert(BankList bankList)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + bankList);

		if (bankList == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		bankList.setCreateAt(currentTimeMillis);
		bankList.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(bankList);
		} catch (DaoException e) {
			log.error(" insert wrong : " + bankList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<BankList> insertList(List<BankList> bankListList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (bankListList == null ? "null" : bankListList.size()));
      
		List<BankList> resultList = null;

		if (CollectionUtils.isEmpty(bankListList)) {
			return new ArrayList<BankList>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (BankList bankList : bankListList) {
			bankList.setCreateAt(currentTimeMillis);
			bankList.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<BankList>) dao.batchSave(bankListList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + bankListList);
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
			result = dao.delete(BankList.class, id);
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
		public boolean update(BankList bankList)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (bankList == null ? "null" : bankList.getId()));

		boolean result = false;

		if (bankList == null) {
			return true;
		}

		bankList.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(bankList);
		} catch (DaoException e) {
			log.error(" update wrong : " + bankList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + bankList);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<BankList> bankListList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (bankListList == null ? "null" : bankListList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(bankListList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (BankList bankList : bankListList) {
			bankList.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(bankListList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + bankListList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + bankListList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public BankList getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		BankList bankList = null;

		if (id == null) {
			return bankList;
		}

		try {
			bankList = (BankList) dao.get(BankList.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return bankList;		
		}	
		  
    	   
		@Override
		public List<BankList> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<BankList> bankList = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<BankList>();
		}

		try {
			bankList = (List<BankList>) dao.getList(BankList.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (bankList == null ? "null" : bankList.size()));
    
		return bankList;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getBankListIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getBankListIdsAll",new Object[] {},start, limit, false);
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
	public Integer countBankListIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getBankListIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getBankListIds " ) ;
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

