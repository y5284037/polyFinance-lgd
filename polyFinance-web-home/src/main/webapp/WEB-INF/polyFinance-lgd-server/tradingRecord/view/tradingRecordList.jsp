<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="tradingRecord" id="current_nav">
<div id="tradingRecordApp" ng-app="tradingRecordApp">
	<div ng-controller="tradingRecordController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>TradingRecord管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addTradingRecord(tradingRecord)">新增</span>
		    </span>
	
			<paging url="/web/a/tradingRecord">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>关联user表的id</td>
			        				                    <td>交易流水号</td>
			        				                    <td>产品名称</td>
			        				                    <td>交易金额</td>
			        				                    <td>交易类型</td>
			        				                    <td>交易状态</td>
			        				                    <td>交易方式(银行,尾号)</td>
			        				                    <td>交易时间</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人id</td>
			        				                    <td>更新人id</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="tradingRecord in data">				
									                    <td ng-bind="tradingRecord.id" ></td>
			        				                    <td ng-bind="tradingRecord.userId" ></td>
			        				                    <td ng-bind="tradingRecord.tradingNum" ></td>
			        				                    <td ng-bind="tradingRecord.productName" ></td>
			        				                    <td ng-bind="tradingRecord.tradingAmount" ></td>
			        				                    <td ng-bind="tradingRecord.tradingType" ></td>
			        				                    <td ng-bind="tradingRecord.tradingStatus" ></td>
			        				                    <td ng-bind="tradingRecord.tradingMode" ></td>
			        				                    <td ng-bind="tradingRecord.tradingTime" ></td>
			        				                    <td ng-bind="tradingRecord.createAt" ></td>
			        				                    <td ng-bind="tradingRecord.updateAt" ></td>
			        				                    <td ng-bind="tradingRecord.createBy" ></td>
			        				                    <td ng-bind="tradingRecord.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateTradingRecord(tradingRecord.id)" /> 
							<input type="button" value="删除" ng-click="deleteTradingRecord(tradingRecord.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/tradingRecord/tradingRecordList.js"></script>
