/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Repayment;
import com.ptteng.polyFinance.lgd.service.RepaymentService;

import java.util.List;
import java.util.Map;

public class RepaymentSCAClient implements RepaymentService {

    private RepaymentService repaymentService;

	public RepaymentService getRepaymentService() {
		return repaymentService;
	}
	
	
	public void setRepaymentService(RepaymentService repaymentService) {
		this.repaymentService =repaymentService;
	}
	
	
			   
		@Override
		public Long insert(Repayment repayment)throws ServiceException, ServiceDaoException{
		
		return repaymentService.insert(repayment);
		          
		
		}	
		  
    	   
		@Override
		public List<Repayment> insertList(List<Repayment> repaymentList)throws ServiceException, ServiceDaoException{
		
		return repaymentService.insertList(repaymentList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return repaymentService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Repayment repayment)throws ServiceException, ServiceDaoException{
		
		return repaymentService.update(repayment);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Repayment> repaymentList)throws ServiceException, ServiceDaoException{
		
		return repaymentService.updateList(repaymentList);
		          
		
		}	
		  
    	   
		@Override
		public Repayment getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return repaymentService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Repayment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return repaymentService.getObjectsByIds(ids);
		          
		
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
		
		return repaymentService.getRepaymentIdsByRepaymentStatus(repaymentStatus,start,limit);
	
	
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
		
		return repaymentService.countRepaymentIdsByRepaymentStatus(repaymentStatus);
	
	
	}
	
		
	
		@Override
	public List<Long> getRepaymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return repaymentService.getRepaymentIds(start, limit);
	}

	@Override
	public Integer countRepaymentIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return repaymentService.countRepaymentIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return repaymentService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return repaymentService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   repaymentService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.repaymentService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

