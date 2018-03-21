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
		<c:forEach items="${tradingRecordList}" var="tradingRecord">
			<json:object>
					
               
                    <json:property name="id" value="${tradingRecord.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="userId" value="${tradingRecord.userId}"></json:property>
           
           
	   
        			
               
                    <json:property name="tradingNum" value="${tradingRecord.tradingNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="productName" value="${tradingRecord.productName}"></json:property>
           
           
	   
        			
               
                    <json:property name="tradingAmount" value="${tradingRecord.tradingAmount}"></json:property>
           
           
	   
        			
               
                    <json:property name="tradingType" value="${tradingRecord.tradingType}"></json:property>
           
           
	   
        			
               
                    <json:property name="tradingStatus" value="${tradingRecord.tradingStatus}"></json:property>
           
           
	   
        			
               
                    <json:property name="tradingMode" value="${tradingRecord.tradingMode}"></json:property>
           
           
	   
        			
               
                    <json:property name="tradingTime" value="${tradingRecord.tradingTime}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${tradingRecord.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${tradingRecord.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${tradingRecord.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${tradingRecord.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


