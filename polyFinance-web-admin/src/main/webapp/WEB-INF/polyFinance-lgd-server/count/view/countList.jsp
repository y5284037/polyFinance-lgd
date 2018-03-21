<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="count" id="current_nav">
<div id="countApp" ng-app="countApp">
	<div ng-controller="countController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Count管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addCount(count)">新增</span>
		    </span>
	
			<paging url="/web/a/count">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>关联product表id</td>
			        				                    <td>统计日期</td>
			        				                    <td>购买人数</td>
			        				                    <td>购买次数</td>
			        				                    <td>购买金额</td>
			        				                    <td>统计时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="count in data">				
									                    <td ng-bind="count.id" ></td>
			        				                    <td ng-bind="count.productId" ></td>
			        				                    <td ng-bind="count.date" ></td>
			        				                    <td ng-bind="count.purchasePeople" ></td>
			        				                    <td ng-bind="count.purchaseTimes" ></td>
			        				                    <td ng-bind="count.purchaseAmount" ></td>
			        				                    <td ng-bind="count.createAt" ></td>
			        				                    <td ng-bind="count.updateAt" ></td>
			        				                    <td ng-bind="count.createBy" ></td>
			        				                    <td ng-bind="count.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateCount(count.id)" /> 
							<input type="button" value="删除" ng-click="deleteCount(count.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/count/countList.js"></script>
