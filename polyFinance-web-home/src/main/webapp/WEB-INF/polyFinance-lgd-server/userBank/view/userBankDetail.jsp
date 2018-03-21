<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="userBank" id="current_nav">
	<div id="userBankDetailApp" ng-app="userBankDetailApp">
		<div ng-controller="userBankDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userBankForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userBankId" ng-model="userBank.id" ng-bind="userBank.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="city" class="col-sm-2 control-label">城市</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="city" ng-model="userBank.city" ng-bind="userBank.city" placeholder="请输入城市" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="bankListId" class="col-sm-2 control-label">关联bank_list表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="bankListId" ng-model="userBank.bankListId" ng-bind="userBank.bankListId" placeholder="请输入关联bank_list表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="bankName" class="col-sm-2 control-label">银行名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="bankName" ng-model="userBank.bankName" ng-bind="userBank.bankName" placeholder="请输入银行名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="cardNo" class="col-sm-2 control-label">银行卡号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="cardNo" ng-model="userBank.cardNo" ng-bind="userBank.cardNo" placeholder="请输入银行卡号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="bankPhone" class="col-sm-2 control-label">预留手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="bankPhone" ng-model="userBank.bankPhone" ng-bind="userBank.bankPhone" placeholder="请输入预留手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">关联user表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="userBank.userId" ng-bind="userBank.userId" placeholder="请输入关联user表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="first" class="col-sm-2 control-label">默认银行卡</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="first" ng-model="userBank.first" ng-bind="userBank.first" placeholder="请输入默认银行卡" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="userBank.createBy" ng-bind="userBank.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="userBank.updateBy" ng-bind="userBank.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUserBank(userBank)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/userBank">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/userBank/userBankDetail.js"></script>
