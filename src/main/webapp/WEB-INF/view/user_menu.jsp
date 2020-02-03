<%--
  Created by IntelliJ IDEA.
  User: getlight
  Date: 09.01.2020
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html lang="${sessionScope.lang}">
<head>
    <title>Menu</title>
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
<!--CONTENT-->
<div class="w3-content" style="max-width:1500px">
    <!--HEADER-->
    <c:import url="parts/header.jsp"/>

    <!--MENU-->
    <div class="w3-panel w3-center w3-opacity">
        <h1><fmt:message key="welcome"/> USER!</h1>

        <div class="w3-padding-32">
            <div class="w3-bar w3-border">
                <a href="<c:url value="/profile"/>" class="w3-bar-item w3-button w3-light-grey"><fmt:message key="profile"/></a>
                <a href="<c:url value="/expositions"/>" class="w3-bar-item w3-button"><fmt:message key="expositions"/></a>
                <a href="<c:url value="/logout"/>" class="w3-bar-item w3-button"><fmt:message key="logout"/></a>
            </div>
        </div>
    </div>

    <!--ACCOUNT-->
    <div class="w3-row">

        <!--USER INFO-->
        <div class="w3-col s3 w3-opacity w3-center w3-padding-16">
            <img class="w3-image" style="max-width: 50%;" src="${pageContext.request.contextPath}/resources/img/user.png">
            <h2><fmt:message key="id"/>: <c:out value="${sessionScope.account.getId()}"/></h2>
            <h2><fmt:message key="login"/>: <c:out value="${sessionScope.account.getLogin()}"/></h2>
            <h2><fmt:message key="role"/>: <c:out value="${sessionScope.account.getRole()}"/></h2>
            <h2><fmt:message key="balance"/>: <c:out value="${sessionScope.account.getBalance()}"/></h2>
            <a href="<c:url value="/donate"/>" class="w3-button w3-black w3-hover-blue"><fmt:message key="addCredits"/></a>
        </div>

        <!--ORDERS INFO-->
        <div class="w3-col s9 w3-opacity w3-center"><h2><fmt:message key="orders"/></h2><br>
            <ul class="w3-ul w3-card-4">
            <c:forEach var="order" items="${sessionScope.orders}">
            <li class="w3-row-padding">
<%--                <img src="img_avatar2.png" class="w3-bar-item w3-circle" style="width:85px">--%>
                <div class="w3-container">
                    <span class="w3-large"><fmt:message key="orderKey"/>: ${order.getOrderKey()}</span><br>
                    <span><fmt:message key="hallId"/>: ${order.getHallId()}, <fmt:message key="hallTheme"/>: ${order.getHallTheme()}, <fmt:message key="dateTo"/>: ${order.getDateValid()}</span>
                </div>
            </li>
            </c:forEach>
            </ul>
        </div>
    </div>

    <!--FOOTER-->
    <c:import url="parts/footer.jsp"/>
</div>
</body>
</html>

