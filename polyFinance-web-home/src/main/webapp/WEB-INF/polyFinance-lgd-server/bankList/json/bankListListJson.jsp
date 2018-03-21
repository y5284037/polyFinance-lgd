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
		<c:forEach items="${bankListList}" var="bankList">
			<json:object>
					
               
                    <json:property name="id" value="${bankList.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${bankList.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="paymentAgencyNumber" value="${bankList.paymentAgencyNumber}"></json:property>
           
           
	   
        			
               
                    <json:property name="withdrawAgencyNumber" value="${bankList.withdrawAgencyNumber}"></json:property>
           
           
	   
        			
               
                    <json:property name="singleTransactionLimit" value="${bankList.singleTransactionLimit}"></json:property>
           
           
	   
        			
               
                    <json:property name="dailyLimit" value="${bankList.dailyLimit}"></json:property>
           
           
	   
        			
               
                    <json:property name="logoPic" value="${bankList.logoPic}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${bankList.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${bankList.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${bankList.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${bankList.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


