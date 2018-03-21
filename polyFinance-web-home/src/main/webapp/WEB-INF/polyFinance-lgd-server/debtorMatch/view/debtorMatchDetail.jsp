<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="debtorMatch" id="current_nav">
	<div id="debtorMatchDetailApp" ng-app="debtorMatchDetailApp">
		<div ng-controller="debtorMatchDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="debtorMatchForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="debtorMatchId" ng-model="debtorMatch.id" ng-bind="debtorMatch.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="debtorId" class="col-sm-2 control-label">关联debtor 的 ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="debtorId" ng-model="debtorMatch.debtorId" ng-bind="debtorMatch.debtorId" placeholder="请输入关联debtor 的 ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="comodatoNum" class="col-sm-2 control-label">出借合同编号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="comodatoNum" ng-model="debtorMatch.comodatoNum" ng-bind="debtorMatch.comodatoNum" placeholder="请输入出借合同编号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="intercreditorAgreement" class="col-sm-2 control-label">债权协议编号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="intercreditorAgreement" ng-model="debtorMatch.intercreditorAgreement" ng-bind="debtorMatch.intercreditorAgreement" placeholder="请输入债权协议编号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">用户姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="debtorMatch.name" ng-bind="debtorMatch.name" placeholder="请输入用户姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productName" class="col-sm-2 control-label">产品名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productName" ng-model="debtorMatch.productName" ng-bind="debtorMatch.productName" placeholder="请输入产品名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="valueDay" class="col-sm-2 control-label">起息日</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="valueDay" ng-model="debtorMatch.valueDay" ng-bind="debtorMatch.valueDay" placeholder="请输入起息日" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="valueEndDay" class="col-sm-2 control-label">到息日</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="valueEndDay" ng-model="debtorMatch.valueEndDay" ng-bind="debtorMatch.valueEndDay" placeholder="请输入到息日" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="investAmount" class="col-sm-2 control-label">投资金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="investAmount" ng-model="debtorMatch.investAmount" ng-bind="debtorMatch.investAmount" placeholder="请输入投资金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="debtorMatch.createBy" ng-bind="debtorMatch.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="debtorMatch.updateBy" ng-bind="debtorMatch.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateDebtorMatch(debtorMatch)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/debtorMatch">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/debtorMatch/debtorMatchDetail.js"></script>
