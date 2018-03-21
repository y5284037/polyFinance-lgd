<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${userMessage.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userId" value="${userMessage.userId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="messageType" value="${userMessage.messageType}"></json:property>
           
           
	   
                    			
               
                    <json:property name="messageReadStatus" value="${userMessage.messageReadStatus}"></json:property>
           
           
	   
                    			
               
                    <json:property name="investRecordId" value="${userMessage.investRecordId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="content" value="${userMessage.content}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${userMessage.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${userMessage.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${userMessage.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${userMessage.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


