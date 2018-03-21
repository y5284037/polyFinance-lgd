<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="repayment" id="current_nav">
	<div id="repaymentDetailApp" ng-app="repaymentDetailApp">
		<div ng-controller="repaymentDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="repaymentForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="repaymentId" ng-model="repayment.id" ng-bind="repayment.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">关联user表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="repayment.userId" ng-bind="repayment.userId" placeholder="请输入关联user表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="investRecordId" class="col-sm-2 control-label">关联invest_record表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="investRecordId" ng-model="repayment.investRecordId" ng-bind="repayment.investRecordId" placeholder="请输入关联invest_record表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="repaymentDate" class="col-sm-2 control-label">还款时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="repaymentDate" ng-model="repayment.repaymentDate" ng-bind="repayment.repaymentDate" placeholder="请输入还款时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="repaymentAmount" class="col-sm-2 control-label">还款金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="repaymentAmount" ng-model="repayment.repaymentAmount" ng-bind="repayment.repaymentAmount" placeholder="请输入还款金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="moneyType" class="col-sm-2 control-label">金额属性(利息,本金)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="moneyType" ng-model="repayment.moneyType" ng-bind="repayment.moneyType" placeholder="请输入金额属性(利息,本金)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="repaymentStatus" class="col-sm-2 control-label">还款状态(未还款,已还款,已续投)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="repaymentStatus" ng-model="repayment.repaymentStatus" ng-bind="repayment.repaymentStatus" placeholder="请输入还款状态(未还款,已还款,已续投)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="repayment.createBy" ng-bind="repayment.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="repayment.updateBy" ng-bind="repayment.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateRepayment(repayment)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/repayment">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/repayment/repaymentDetail.js"></script>
