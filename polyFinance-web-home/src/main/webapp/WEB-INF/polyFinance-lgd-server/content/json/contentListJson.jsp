<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${contentList}" var="content">
			<json:object>
					
               
                    <json:property name="id" value="${content.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="title" value="${content.title}"></json:property>
           
           
	   
        			
               
                    <json:property name="type" value="${content.type}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${content.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="contentCoverPic" value="${content.contentCoverPic}"></json:property>
           
           
	   
        			
               
                    <json:property name="contentPic" value="${content.contentPic}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${content.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${content.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${content.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${content.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


