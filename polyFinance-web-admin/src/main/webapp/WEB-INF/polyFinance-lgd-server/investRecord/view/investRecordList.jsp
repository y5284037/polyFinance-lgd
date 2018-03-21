<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="investRecord" id="current_nav">
<div id="investRecordApp" ng-app="investRecordApp">
	<div ng-controller="investRecordController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>InvestRecord管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addInvestRecord(investRecord)">新增</span>
		    </span>
	
			<paging url="/web/a/investRecord">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>关联user表id</td>
			        				                    <td>关联product表id</td>
			        				                    <td>产品名称</td>
			        				                    <td>收益率(无%)</td>
			        				                    <td>还款方式</td>
			        				                    <td>起投金额</td>
			        				                    <td>回款银行</td>
			        				                    <td>回款银行卡号</td>
			        				                    <td>回款银行名称</td>
			        				                    <td>投资金额</td>
			        				                    <td>出借合同编号</td>
			        				                    <td>债权协议编号</td>
			        				                    <td>投资状态</td>
			        				                    <td>未分配收益</td>
			        				                    <td>分配收益</td>
			        				                    <td>起息日</td>
			        				                    <td>到息日</td>
			        				                    <td>创建时间</td>
			        				                    <td>创建人id</td>
			        				                    <td>更新时间</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="investRecord in data">				
									                    <td ng-bind="investRecord.id" ></td>
			        				                    <td ng-bind="investRecord.userId" ></td>
			        				                    <td ng-bind="investRecord.productId" ></td>
			        				                    <td ng-bind="investRecord.productName" ></td>
			        				                    <td ng-bind="investRecord.productInterestRate" ></td>
			        				                    <td ng-bind="investRecord.productPaymentMethod" ></td>
			        				                    <td ng-bind="investRecord.productInterestAmountLine" ></td>
			        				                    <td ng-bind="investRecord.repaymentBank" ></td>
			        				                    <td ng-bind="investRecord.repaymentCard" ></td>
			        				                    <td ng-bind="investRecord.repaymentBankName" ></td>
			        				                    <td ng-bind="investRecord.investAmount" ></td>
			        				                    <td ng-bind="investRecord.comodatoNum" ></td>
			        				                    <td ng-bind="investRecord.intercreditorAgreement" ></td>
			        				                    <td ng-bind="investRecord.investStatus" ></td>
			        				                    <td ng-bind="investRecord.undistributedIncome" ></td>
			        				                    <td ng-bind="investRecord.distributionIncome" ></td>
			        				                    <td ng-bind="investRecord.valueDay" ></td>
			        				                    <td ng-bind="investRecord.valueEndDay" ></td>
			        				                    <td ng-bind="investRecord.createAt" ></td>
			        				                    <td ng-bind="investRecord.createBy" ></td>
			        				                    <td ng-bind="investRecord.updateAt" ></td>
			        				                    <td ng-bind="investRecord.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateInvestRecord(investRecord.id)" /> 
							<input type="button" value="删除" ng-click="deleteInvestRecord(investRecord.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/investRecord/investRecordList.js"></script>
