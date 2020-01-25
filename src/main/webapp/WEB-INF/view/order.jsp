<%--
  Created by IntelliJ IDEA.
  User: getlight
  Date: 25.01.2020
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title>Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster">
    <style>
        .w3-lobster {
            font-family: "Lobster", serif;
        }
    </style>
</head>
<body>
<div class="w3-content" style="max-width:1500px">
    <c:import url="parts/header.jsp"/>

    <!--MENU-->
    <div class="w3-panel w3-center w3-opacity">
        <h1><fmt:message key="order"/></h1>

        <div class="w3-padding-32">
            <div class="w3-bar w3-border">
                <a href="" class="w3-bar-item w3-button"><fmt:message key="profile"/></a>
                <a href="" class="w3-bar-item w3-button"><fmt:message key="expositions"/></a>
                <a href="<c:url value="/logout"/>" class="w3-bar-item w3-button"><fmt:message key="logout"/></a>
            </div>
        </div>
    </div>

    <c:import url="parts/footer.jsp"/>
</div>
</body>
</html>
