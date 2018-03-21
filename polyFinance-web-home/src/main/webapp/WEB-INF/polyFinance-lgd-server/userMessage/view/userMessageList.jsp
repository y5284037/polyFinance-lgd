<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="userMessage" id="current_nav">
<div id="userMessageApp" ng-app="userMessageApp">
	<div ng-controller="userMessageController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>UserMessage管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUserMessage(userMessage)">新增</span>
		    </span>
	
			<paging url="/web/a/userMessage">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>关联user表id</td>
			        				                    <td>消息类型</td>
			        				                    <td>消息阅读状态</td>
			        				                    <td>投资详情表id</td>
			        				                    <td>消息内容</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="userMessage in data">				
									                    <td ng-bind="userMessage.id" ></td>
			        				                    <td ng-bind="userMessage.userId" ></td>
			        				                    <td ng-bind="userMessage.messageType" ></td>
			        				                    <td ng-bind="userMessage.messageReadStatus" ></td>
			        				                    <td ng-bind="userMessage.investRecordId" ></td>
			        				                    <td ng-bind="userMessage.content" ></td>
			        				                    <td ng-bind="userMessage.createAt" ></td>
			        				                    <td ng-bind="userMessage.updateAt" ></td>
			        				                    <td ng-bind="userMessage.createBy" ></td>
			        				                    <td ng-bind="userMessage.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUserMessage(userMessage.id)" /> 
							<input type="button" value="删除" ng-click="deleteUserMessage(userMessage.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/userMessage/userMessageList.js"></script>
