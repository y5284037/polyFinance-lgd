<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="sysMessageReaded" id="current_nav">
<div id="sysMessageReadedApp" ng-app="sysMessageReadedApp">
	<div ng-controller="sysMessageReadedController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>SysMessageReaded管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addSysMessageReaded(sysMessageReaded)">新增</span>
		    </span>
	
			<paging url="/web/a/sysMessageReaded">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>关联user表id</td>
			        				                    <td>关联sys_message表id</td>
			        				                    <td>创建时间</td>
			        				                    <td>创建人id</td>
			        				                    <td>阅读状态</td>
			        				                    <td>删除状态</td>
			        				                    <td>更新时间</td>
			        				                    <td>更新人id</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="sysMessageReaded in data">				
									                    <td ng-bind="sysMessageReaded.id" ></td>
			        				                    <td ng-bind="sysMessageReaded.userId" ></td>
			        				                    <td ng-bind="sysMessageReaded.sysMessageId" ></td>
			        				                    <td ng-bind="sysMessageReaded.createAt" ></td>
			        				                    <td ng-bind="sysMessageReaded.createBy" ></td>
			        				                    <td ng-bind="sysMessageReaded.readStatus" ></td>
			        				                    <td ng-bind="sysMessageReaded.deleteStatus" ></td>
			        				                    <td ng-bind="sysMessageReaded.updateAt" ></td>
			        				                    <td ng-bind="sysMessageReaded.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateSysMessageReaded(sysMessageReaded.id)" /> 
							<input type="button" value="删除" ng-click="deleteSysMessageReaded(sysMessageReaded.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/sysMessageReaded/sysMessageReadedList.js"></script>
