<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="sysMessage" id="current_nav">
<div id="sysMessageApp" ng-app="sysMessageApp">
	<div ng-controller="sysMessageController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>SysMessage管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addSysMessage(sysMessage)">新增</span>
		    </span>
	
			<paging url="/web/a/sysMessage">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>标题</td>
			        				                    <td>状态(上线,草稿)</td>
			        				                    <td>摘要</td>
			        				                    <td>图片内容</td>
			        				                    <td>消息类型</td>
			        				                    <td>发送类型</td>
			        				                    <td>发送时间</td>
			        				                    <td>发送人群</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>编辑人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="sysMessage in data">				
									                    <td ng-bind="sysMessage.id" ></td>
			        				                    <td ng-bind="sysMessage.title" ></td>
			        				                    <td ng-bind="sysMessage.status" ></td>
			        				                    <td ng-bind="sysMessage.resume" ></td>
			        				                    <td ng-bind="sysMessage.messagePic" ></td>
			        				                    <td ng-bind="sysMessage.messageType" ></td>
			        				                    <td ng-bind="sysMessage.sendType" ></td>
			        				                    <td ng-bind="sysMessage.sendTime" ></td>
			        				                    <td ng-bind="sysMessage.sendTo" ></td>
			        				                    <td ng-bind="sysMessage.createAt" ></td>
			        				                    <td ng-bind="sysMessage.updateAt" ></td>
			        				                    <td ng-bind="sysMessage.createBy" ></td>
			        				                    <td ng-bind="sysMessage.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateSysMessage(sysMessage.id)" /> 
							<input type="button" value="删除" ng-click="deleteSysMessage(sysMessage.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/sysMessage/sysMessageList.js"></script>
