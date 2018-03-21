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
		<c:forEach items="${userList}" var="user">
			<json:object>
					
               
                    <json:property name="id" value="${user.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="serialNum" value="${user.serialNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="phoneNum" value="${user.phoneNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="pswd" value="${user.pswd}"></json:property>
           
           
	   
        			
               
                    <json:property name="salt" value="${user.salt}"></json:property>
           
           
	   
        			
               
                    <json:property name="managerNum" value="${user.managerNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${user.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="totalProperty" value="${user.totalProperty}"></json:property>
           
           
	   
        			
               
                    <json:property name="income" value="${user.income}"></json:property>
           
           
	   
        			
               
                    <json:property name="accountsStatus" value="${user.accountsStatus}"></json:property>
           
           
	   
        			
               
                    <json:property name="address" value="${user.address}"></json:property>
           
           
	   
        			
               
                    <json:property name="email" value="${user.email}"></json:property>
           
           
	   
        			
               
                    <json:property name="idCardFornt" value="${user.idCardFornt}"></json:property>
           
           
	   
        			
               
                    <json:property name="idCardBack" value="${user.idCardBack}"></json:property>
           
           
	   
        			
               
                    <json:property name="idCard" value="${user.idCard}"></json:property>
           
           
	   
        			
               
                    <json:property name="identityStatus" value="${user.identityStatus}"></json:property>
           
           
	   
        			
               
                    <json:property name="refuseReason" value="${user.refuseReason}"></json:property>
           
           
	   
        			
               
                    <json:property name="refuseStatus" value="${user.refuseStatus}"></json:property>
           
           
	   
        			
               
                    <json:property name="identityTime" value="${user.identityTime}"></json:property>
           
           
	   
        			
               
                    <json:property name="userBankId" value="${user.userBankId}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${user.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${user.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${user.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${user.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


