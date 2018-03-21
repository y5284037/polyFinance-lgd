<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="product" id="current_nav">
	<div id="productDetailApp" ng-app="productDetailApp">
		<div ng-controller="productDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="productForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="productId" ng-model="product.id" ng-bind="product.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productMark" class="col-sm-2 control-label">产品代号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productMark" ng-model="product.productMark" ng-bind="product.productMark" placeholder="请输入产品代号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">产品名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="product.name" ng-bind="product.name" placeholder="请输入产品名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="interestRate" class="col-sm-2 control-label">收益率(无%)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="interestRate" ng-model="product.interestRate" ng-bind="product.interestRate" placeholder="请输入收益率(无%)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="financialPeriodDay" class="col-sm-2 control-label">投资期限(天)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="financialPeriodDay" ng-model="product.financialPeriodDay" ng-bind="product.financialPeriodDay" placeholder="请输入投资期限(天)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="financialPeriodMonth" class="col-sm-2 control-label">投资期限(月)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="financialPeriodMonth" ng-model="product.financialPeriodMonth" ng-bind="product.financialPeriodMonth" placeholder="请输入投资期限(月)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="paymentMethod" class="col-sm-2 control-label">还款方式</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="paymentMethod" ng-model="product.paymentMethod" ng-bind="product.paymentMethod" placeholder="请输入还款方式" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="interestDelayed" class="col-sm-2 control-label">起息日期(延后多少天算利息)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="interestDelayed" ng-model="product.interestDelayed" ng-bind="product.interestDelayed" placeholder="请输入起息日期(延后多少天算利息)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="productStatus" class="col-sm-2 control-label">产品状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="productStatus" ng-model="product.productStatus" ng-bind="product.productStatus" placeholder="请输入产品状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="interestAmountLine" class="col-sm-2 control-label">起投金额</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="interestAmountLine" ng-model="product.interestAmountLine" ng-bind="product.interestAmountLine" placeholder="请输入起投金额" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="remark" class="col-sm-2 control-label">备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="remark" ng-model="product.remark" ng-bind="product.remark" placeholder="请输入备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="detailsPic" class="col-sm-2 control-label">更多详情</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="detailsPic" ng-model="product.detailsPic" ng-bind="product.detailsPic" placeholder="请输入更多详情" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="hotCornerMark" class="col-sm-2 control-label">热门产品</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="hotCornerMark" ng-model="product.hotCornerMark" ng-bind="product.hotCornerMark" placeholder="请输入热门产品" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="newCornerMark" class="col-sm-2 control-label">新近产品</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="newCornerMark" ng-model="product.newCornerMark" ng-bind="product.newCornerMark" placeholder="请输入新近产品" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="recommended" class="col-sm-2 control-label">精品推荐</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="recommended" ng-model="product.recommended" ng-bind="product.recommended" placeholder="请输入精品推荐" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="limited" class="col-sm-2 control-label">限购</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="limited" ng-model="product.limited" ng-bind="product.limited" placeholder="请输入限购" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="product.createBy" ng-bind="product.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="product.updateBy" ng-bind="product.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateProduct(product)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/product">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/product/productDetail.js"></script>
