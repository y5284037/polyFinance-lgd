<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${count.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="productId" value="${count.productId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="date" value="${count.date}"></json:property>
           
           
	   
                    			
               
                    <json:property name="purchasePeople" value="${count.purchasePeople}"></json:property>
           
           
	   
                    			
               
                    <json:property name="purchaseTimes" value="${count.purchaseTimes}"></json:property>
           
           
	   
                    			
               
                    <json:property name="purchaseAmount" value="${count.purchaseAmount}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${count.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${count.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${count.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${count.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


