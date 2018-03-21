<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="tradingRecord" id="current_nav">
	<div id="tradingRecordDetailApp" ng-app="tradingRecordDetailApp">
		<div ng-controller="tradingRecordDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="tradingRecordForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="tradingRecordId" ng-model="tradingRecord.id" ng-bind="tradingRecord.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">关联user表的id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="tradingRecord.userId" ng-bind="tradingRecord.userId" placeholder="请输入关联user表的id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tradingNum" class="col-sm-2 control-label">交易流水号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tradingNum" ng-model="tradingRecord.tradingNum" ng-bind="tradingRecord.tradingNum" placeholder="请输入交易流水号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productName" class="col-sm-2 control-label">产品名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productName" ng-model="tradingRecord.productName" ng-bind="tradingRecord.productName" placeholder="请输入产品名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tradingAmount" class="col-sm-2 control-label">交易金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tradingAmount" ng-model="tradingRecord.tradingAmount" ng-bind="tradingRecord.tradingAmount" placeholder="请输入交易金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tradingType" class="col-sm-2 control-label">交易类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tradingType" ng-model="tradingRecord.tradingType" ng-bind="tradingRecord.tradingType" placeholder="请输入交易类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tradingStatus" class="col-sm-2 control-label">交易状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tradingStatus" ng-model="tradingRecord.tradingStatus" ng-bind="tradingRecord.tradingStatus" placeholder="请输入交易状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tradingMode" class="col-sm-2 control-label">交易方式(银行,尾号)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tradingMode" ng-model="tradingRecord.tradingMode" ng-bind="tradingRecord.tradingMode" placeholder="请输入交易方式(银行,尾号)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="tradingTime" class="col-sm-2 control-label">交易时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="tradingTime" ng-model="tradingRecord.tradingTime" ng-bind="tradingRecord.tradingTime" placeholder="请输入交易时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="tradingRecord.createBy" ng-bind="tradingRecord.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="tradingRecord.updateBy" ng-bind="tradingRecord.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateTradingRecord(tradingRecord)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/tradingRecord">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/tradingRecord/tradingRecordDetail.js"></script>
