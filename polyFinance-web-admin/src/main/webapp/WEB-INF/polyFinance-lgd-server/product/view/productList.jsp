<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="product" id="current_nav">
<div id="productApp" ng-app="productApp">
	<div ng-controller="productController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Product管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addProduct(product)">新增</span>
		    </span>
	
			<paging url="/web/a/product">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>产品代号</td>
			        				                    <td>产品名称</td>
			        				                    <td>收益率(无%)</td>
			        				                    <td>投资期限(天)</td>
			        				                    <td>投资期限(月)</td>
			        				                    <td>还款方式</td>
			        				                    <td>起息日期(延后多少天算利息)</td>
			        				                    <td>产品状态</td>
			        				                    <td>起投金额</td>
			        				                    <td>备注</td>
			        				                    <td>更多详情</td>
			        				                    <td>热门产品</td>
			        				                    <td>新近产品</td>
			        				                    <td>精品推荐</td>
			        				                    <td>限购</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="product in data">				
									                    <td ng-bind="product.id" ></td>
			        				                    <td ng-bind="product.productMark" ></td>
			        				                    <td ng-bind="product.name" ></td>
			        				                    <td ng-bind="product.interestRate" ></td>
			        				                    <td ng-bind="product.financialPeriodDay" ></td>
			        				                    <td ng-bind="product.financialPeriodMonth" ></td>
			        				                    <td ng-bind="product.paymentMethod" ></td>
			        				                    <td ng-bind="product.interestDelayed" ></td>
			        				                    <td ng-bind="product.productStatus" ></td>
			        				                    <td ng-bind="product.interestAmountLine" ></td>
			        				                    <td ng-bind="product.remark" ></td>
			        				                    <td ng-bind="product.detailsPic" ></td>
			        				                    <td ng-bind="product.hotCornerMark" ></td>
			        				                    <td ng-bind="product.newCornerMark" ></td>
			        				                    <td ng-bind="product.recommended" ></td>
			        				                    <td ng-bind="product.limited" ></td>
			        				                    <td ng-bind="product.createAt" ></td>
			        				                    <td ng-bind="product.updateAt" ></td>
			        				                    <td ng-bind="product.createBy" ></td>
			        				                    <td ng-bind="product.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateProduct(product.id)" /> 
							<input type="button" value="删除" ng-click="deleteProduct(product.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/product/productList.js"></script>
