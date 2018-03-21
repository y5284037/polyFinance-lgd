<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${sysMessage.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="title" value="${sysMessage.title}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${sysMessage.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="resume" value="${sysMessage.resume}"></json:property>
           
           
	   
                    			
               
                    <json:property name="messagePic" value="${sysMessage.messagePic}"></json:property>
           
           
	   
                    			
               
                    <json:property name="messageType" value="${sysMessage.messageType}"></json:property>
           
           
	   
                    			
               
                    <json:property name="sendType" value="${sysMessage.sendType}"></json:property>
           
           
	   
                    			
               
                    <json:property name="sendTime" value="${sysMessage.sendTime}"></json:property>
           
           
	   
                    			
               
                    <json:property name="sendTo" value="${sysMessage.sendTo}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${sysMessage.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${sysMessage.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${sysMessage.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${sysMessage.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


