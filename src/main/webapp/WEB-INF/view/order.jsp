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
<%@ page session="true" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html lang="${sessionScope.lang}">
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
<!--CONTENT-->
<div class="w3-content" style="max-width:1500px">
    <!--HEADER-->
    <c:import url="parts/header.jsp"/>

    <!--MENU-->
    <div class="w3-panel w3-center w3-opacity">
        <h1><fmt:message key="order"/></h1>

        <div class="w3-padding-32">
            <div class="w3-bar w3-border">
                <a href="<c:url value="/profile"/>" class="w3-bar-item w3-button"><fmt:message key="profile"/></a>
                <a href="<c:url value="/expositions"/>" class="w3-bar-item w3-button"><fmt:message
                        key="expositions"/></a>
                <a href="<c:url value="/logout"/>" class="w3-bar-item w3-button"><fmt:message key="logout"/></a>
            </div>
        </div>
    </div>

    <!--ORDER PANEL-->
    <div class="w3-panel w3-center w3-opacity" style="padding:30px 16px 50px 16px">
        <c:choose>
            <c:when test="${sessionScope.result == 'success'}">
                <!--PAYMENT SUCCESS MESSAGE-->
                <div class="w3-panel w3-center" style="padding:64px 16px">
                    <b><h2 class="w3-text-green w3-xxxlarge w3-lobster"><fmt:message key="paymentSuccess"/></h2></b>
                    <b><h2 class="w3-text-green w3-xxlarge w3-lobster"><fmt:message key="checkProfile"/></h2></b>
                </div>
            </c:when>
            <c:when test="${sessionScope.result == 'fail'}">
                <!--PAYMENT FAIL MESSAGE-->
                <div class="w3-panel w3-center" style="padding:64px 16px">
                    <b><h2 class="w3-text-red w3-xxxlarge w3-lobster"><fmt:message key="paymentFail"/></h2></b>
                    <b><h2 class="w3-text-red w3-xxlarge w3-lobster"><fmt:message key="insufficient"/></h2></b>
                    <a href="<c:url value="/donate"/>" class="w3-button w3-black w3-hover-blue"><fmt:message key="addCredits"/></a>
                </div>
            </c:when>
            <c:otherwise>
                <!--ORDER FORM-->
                <form method="post" class="w3-container w3-center"
                      style="max-width: 50%; text-align: center; display: inline-block;">
                    <div class="w3-row-padding w3-left-align" style="margin-bottom: 10px;">
                        <h2><fmt:message key="hallId"/>: ${sessionScope.hall.getId()}</h2>
                        <h2><fmt:message key="hallTheme"/>: ${sessionScope.hall.getTheme()}</h2>
                        <h2><fmt:message key="price"/>: ${sessionScope.hall.getTicketPrice()}$</h2>
                    </div>
                    <div class="w3-row">
                        <div class="w3-container">
                            <input class="w3-button w3-block w3-black w3-hover-blue w3-center"
                                   style="padding: 10px 100px;"
                                   type="submit" name="submit" value="<fmt:message key="confirm" />">
                        </div>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>

    <!--FOOTER-->
    <c:import url="parts/footer.jsp"/>
</div>
</body>
</html>
