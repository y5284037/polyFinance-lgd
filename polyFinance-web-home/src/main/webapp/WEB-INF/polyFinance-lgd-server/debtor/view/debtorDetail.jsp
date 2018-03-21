<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="debtor" id="current_nav">
	<div id="debtorDetailApp" ng-app="debtorDetailApp">
		<div ng-controller="debtorDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="debtorForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="debtorId" ng-model="debtor.id" ng-bind="debtor.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="debtorMark" class="col-sm-2 control-label">债务人编号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="debtorMark" ng-model="debtor.debtorMark" ng-bind="debtor.debtorMark" placeholder="请输入债务人编号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="debtorName" class="col-sm-2 control-label">姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="debtorName" ng-model="debtor.debtorName" ng-bind="debtor.debtorName" placeholder="请输入姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="debtorPhone" class="col-sm-2 control-label">手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="debtorPhone" ng-model="debtor.debtorPhone" ng-bind="debtor.debtorPhone" placeholder="请输入手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="debtorIDcard" class="col-sm-2 control-label">债务人身份证号码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="debtorIDcard" ng-model="debtor.debtorIDcard" ng-bind="debtor.debtorIDcard" placeholder="请输入债务人身份证号码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="expires" class="col-sm-2 control-label">出借期限</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="expires" ng-model="debtor.expires" ng-bind="debtor.expires" placeholder="请输入出借期限" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="debtStartTime" class="col-sm-2 control-label">出借日期</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="debtStartTime" ng-model="debtor.debtStartTime" ng-bind="debtor.debtStartTime" placeholder="请输入出借日期" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="debtEndTime" class="col-sm-2 control-label">到期日期</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="debtEndTime" ng-model="debtor.debtEndTime" ng-bind="debtor.debtEndTime" placeholder="请输入到期日期" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="amount" class="col-sm-2 control-label">出借金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="amount" ng-model="debtor.amount" ng-bind="debtor.amount" placeholder="请输入出借金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="debtorInvest" class="col-sm-2 control-label">债权年利率</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="debtorInvest" ng-model="debtor.debtorInvest" ng-bind="debtor.debtorInvest" placeholder="请输入债权年利率" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="debtor.status" ng-bind="debtor.status" placeholder="请输入状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="matchedAmount" class="col-sm-2 control-label">匹配金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="matchedAmount" ng-model="debtor.matchedAmount" ng-bind="debtor.matchedAmount" placeholder="请输入匹配金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="remark" class="col-sm-2 control-label">备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="remark" ng-model="debtor.remark" ng-bind="debtor.remark" placeholder="请输入备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="nature" class="col-sm-2 control-label">债权性质</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="nature" ng-model="debtor.nature" ng-bind="debtor.nature" placeholder="请输入债权性质" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="debtor.createBy" ng-bind="debtor.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="debtor.updateBy" ng-bind="debtor.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateDebtor(debtor)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/debtor">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/debtor/debtorDetail.js"></script>
