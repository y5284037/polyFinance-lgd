<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="content" id="current_nav">
<div id="contentApp" ng-app="contentApp">
	<div ng-controller="contentController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Content管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addContent(content)">新增</span>
		    </span>
	
			<paging url="/web/a/content">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>标题</td>
			        				                    <td>类型</td>
			        				                    <td>状态</td>
			        				                    <td>内容封面</td>
			        				                    <td>内容详情</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="content in data">				
									                    <td ng-bind="content.id" ></td>
			        				                    <td ng-bind="content.title" ></td>
			        				                    <td ng-bind="content.type" ></td>
			        				                    <td ng-bind="content.status" ></td>
			        				                    <td ng-bind="content.contentCoverPic" ></td>
			        				                    <td ng-bind="content.contentPic" ></td>
			        				                    <td ng-bind="content.createAt" ></td>
			        				                    <td ng-bind="content.updateAt" ></td>
			        				                    <td ng-bind="content.createBy" ></td>
			        				                    <td ng-bind="content.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateContent(content.id)" /> 
							<input type="button" value="删除" ng-click="deleteContent(content.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/content/contentList.js"></script>
