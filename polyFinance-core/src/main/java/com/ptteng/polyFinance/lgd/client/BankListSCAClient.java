/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.BankList;
import com.ptteng.polyFinance.lgd.service.BankListService;

import java.util.List;
import java.util.Map;

public class BankListSCAClient implements BankListService {

    private BankListService bankListService;

	public BankListService getBankListService() {
		return bankListService;
	}
	
	
	public void setBankListService(BankListService bankListService) {
		this.bankListService =bankListService;
	}
	
	
			   
		@Override
		public Long insert(BankList bankList)throws ServiceException, ServiceDaoException{
		
		return bankListService.insert(bankList);
		          
		
		}	
		  
    	   
		@Override
		public List<BankList> insertList(List<BankList> bankListList)throws ServiceException, ServiceDaoException{
		
		return bankListService.insertList(bankListList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return bankListService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(BankList bankList)throws ServiceException, ServiceDaoException{
		
		return bankListService.update(bankList);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<BankList> bankListList)throws ServiceException, ServiceDaoException{
		
		return bankListService.updateList(bankListList);
		          
		
		}	
		  
    	   
		@Override
		public BankList getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return bankListService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<BankList> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return bankListService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getBankListIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return bankListService.getBankListIds(start, limit);
	}

	@Override
	public Integer countBankListIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return bankListService.countBankListIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return bankListService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return bankListService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   bankListService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.bankListService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

