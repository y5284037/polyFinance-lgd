<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="bankList" id="current_nav">
	<div id="bankListDetailApp" ng-app="bankListDetailApp">
		<div ng-controller="bankListDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="bankListForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="bankListId" ng-model="bankList.id" ng-bind="bankList.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">银行名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="bankList.name" ng-bind="bankList.name" placeholder="请输入银行名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="paymentAgencyNumber" class="col-sm-2 control-label">支付机构号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="paymentAgencyNumber" ng-model="bankList.paymentAgencyNumber" ng-bind="bankList.paymentAgencyNumber" placeholder="请输入支付机构号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="withdrawAgencyNumber" class="col-sm-2 control-label">提现机构号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="withdrawAgencyNumber" ng-model="bankList.withdrawAgencyNumber" ng-bind="bankList.withdrawAgencyNumber" placeholder="请输入提现机构号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="SingleTransactionLimit" class="col-sm-2 control-label">单笔限额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="SingleTransactionLimit" ng-model="bankList.SingleTransactionLimit" ng-bind="bankList.SingleTransactionLimit" placeholder="请输入单笔限额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="DailyLimit" class="col-sm-2 control-label">日累计限额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="DailyLimit" ng-model="bankList.DailyLimit" ng-bind="bankList.DailyLimit" placeholder="请输入日累计限额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="logoPic" class="col-sm-2 control-label">ICON</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="logoPic" ng-model="bankList.logoPic" ng-bind="bankList.logoPic" placeholder="请输入ICON" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="bankList.createBy" ng-bind="bankList.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="bankList.updateBy" ng-bind="bankList.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateBankList(bankList)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/bankList">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/bankList/bankListDetail.js"></script>
