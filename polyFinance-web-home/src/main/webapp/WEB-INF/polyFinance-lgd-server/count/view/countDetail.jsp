<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="count" id="current_nav">
	<div id="countDetailApp" ng-app="countDetailApp">
		<div ng-controller="countDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="countForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="countId" ng-model="count.id" ng-bind="count.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productId" class="col-sm-2 control-label">关联product表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productId" ng-model="count.productId" ng-bind="count.productId" placeholder="请输入关联product表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="date" class="col-sm-2 control-label">统计日期</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="date" ng-model="count.date" ng-bind="count.date" placeholder="请输入统计日期" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="purchasePeople" class="col-sm-2 control-label">购买人数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="purchasePeople" ng-model="count.purchasePeople" ng-bind="count.purchasePeople" placeholder="请输入购买人数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="purchaseTimes" class="col-sm-2 control-label">购买次数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="purchaseTimes" ng-model="count.purchaseTimes" ng-bind="count.purchaseTimes" placeholder="请输入购买次数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="purchaseAmount" class="col-sm-2 control-label">购买金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="purchaseAmount" ng-model="count.purchaseAmount" ng-bind="count.purchaseAmount" placeholder="请输入购买金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="count.createBy" ng-bind="count.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="count.updateBy" ng-bind="count.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateCount(count)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/count">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/count/countDetail.js"></script>
