<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:property name="roleName" value="${adminRole.roleName}"/>

    <json:array name="authority">
        <c:forEach items="${moduleIds}" var="moduleId">

            <json:property value="${moduleId}"/>
        </c:forEach>

    </json:array>


</json:object>


