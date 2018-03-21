<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${sysMessageReaded.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userId" value="${sysMessageReaded.userId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="sysMessageId" value="${sysMessageReaded.sysMessageId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${sysMessageReaded.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${sysMessageReaded.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="readStatus" value="${sysMessageReaded.readStatus}"></json:property>
           
           
	   
                    			
               
                    <json:property name="deleteStatus" value="${sysMessageReaded.deleteStatus}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${sysMessageReaded.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${sysMessageReaded.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


