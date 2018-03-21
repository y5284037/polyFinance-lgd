<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="investRecord" id="current_nav">
	<div id="investRecordDetailApp" ng-app="investRecordDetailApp">
		<div ng-controller="investRecordDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="investRecordForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="investRecordId" ng-model="investRecord.id" ng-bind="investRecord.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">关联user表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="investRecord.userId" ng-bind="investRecord.userId" placeholder="请输入关联user表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productId" class="col-sm-2 control-label">关联product表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productId" ng-model="investRecord.productId" ng-bind="investRecord.productId" placeholder="请输入关联product表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productName" class="col-sm-2 control-label">产品名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productName" ng-model="investRecord.productName" ng-bind="investRecord.productName" placeholder="请输入产品名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productInterestRate" class="col-sm-2 control-label">收益率(无%)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productInterestRate" ng-model="investRecord.productInterestRate" ng-bind="investRecord.productInterestRate" placeholder="请输入收益率(无%)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productPaymentMethod" class="col-sm-2 control-label">还款方式</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productPaymentMethod" ng-model="investRecord.productPaymentMethod" ng-bind="investRecord.productPaymentMethod" placeholder="请输入还款方式" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productInterestAmountLine" class="col-sm-2 control-label">起投金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productInterestAmountLine" ng-model="investRecord.productInterestAmountLine" ng-bind="investRecord.productInterestAmountLine" placeholder="请输入起投金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="repaymentBank" class="col-sm-2 control-label">回款银行</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="repaymentBank" ng-model="investRecord.repaymentBank" ng-bind="investRecord.repaymentBank" placeholder="请输入回款银行" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="repaymentCard" class="col-sm-2 control-label">回款银行卡号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="repaymentCard" ng-model="investRecord.repaymentCard" ng-bind="investRecord.repaymentCard" placeholder="请输入回款银行卡号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="repaymentBankName" class="col-sm-2 control-label">回款银行名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="repaymentBankName" ng-model="investRecord.repaymentBankName" ng-bind="investRecord.repaymentBankName" placeholder="请输入回款银行名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="investAmount" class="col-sm-2 control-label">投资金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="investAmount" ng-model="investRecord.investAmount" ng-bind="investRecord.investAmount" placeholder="请输入投资金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="comodatoNum" class="col-sm-2 control-label">出借合同编号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="comodatoNum" ng-model="investRecord.comodatoNum" ng-bind="investRecord.comodatoNum" placeholder="请输入出借合同编号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="intercreditorAgreement" class="col-sm-2 control-label">债权协议编号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="intercreditorAgreement" ng-model="investRecord.intercreditorAgreement" ng-bind="investRecord.intercreditorAgreement" placeholder="请输入债权协议编号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="investStatus" class="col-sm-2 control-label">投资状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="investStatus" ng-model="investRecord.investStatus" ng-bind="investRecord.investStatus" placeholder="请输入投资状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="undistributedIncome" class="col-sm-2 control-label">未分配收益</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="undistributedIncome" ng-model="investRecord.undistributedIncome" ng-bind="investRecord.undistributedIncome" placeholder="请输入未分配收益" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="distributionIncome" class="col-sm-2 control-label">分配收益</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="distributionIncome" ng-model="investRecord.distributionIncome" ng-bind="investRecord.distributionIncome" placeholder="请输入分配收益" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="valueDay" class="col-sm-2 control-label">起息日</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="valueDay" ng-model="investRecord.valueDay" ng-bind="investRecord.valueDay" placeholder="请输入起息日" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="valueEndDay" class="col-sm-2 control-label">到息日</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="valueEndDay" ng-model="investRecord.valueEndDay" ng-bind="investRecord.valueEndDay" placeholder="请输入到息日" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="investRecord.createBy" ng-bind="investRecord.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="investRecord.updateBy" ng-bind="investRecord.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateInvestRecord(investRecord)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/investRecord">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/investRecord/investRecordDetail.js"></script>
