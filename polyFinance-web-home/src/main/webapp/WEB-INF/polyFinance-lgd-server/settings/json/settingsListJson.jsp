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
		<c:forEach items="${settingsList}" var="settings">
			<json:object>
					
               
                    <json:property name="id" value="${settings.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="companyChop" value="${settings.companyChop}"></json:property>
           
           
	   
        			
               
                    <json:property name="invsetExpireWarn" value="${settings.invsetExpireWarn}"></json:property>
           
           
	   
        			
               
                    <json:property name="daysBeforeMaturity" value="${settings.daysBeforeMaturity}"></json:property>
           
           
	   
        			
               
                    <json:property name="investFullLine" value="${settings.investFullLine}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${settings.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${settings.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${settings.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${settings.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${settings.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


