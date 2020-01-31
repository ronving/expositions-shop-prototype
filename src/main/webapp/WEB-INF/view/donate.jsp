<%--
  Created by IntelliJ IDEA.
  User: getlight
  Date: 25.01.2020
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html lang="${sessionScope.lang}">
<head>
    <title>Donate</title>
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
        <h1><fmt:message key="payment"/></h1>

        <div class="w3-padding-32">
            <div class="w3-bar w3-border">
                <a href="<c:url value="/profile"/>" class="w3-bar-item w3-button"><fmt:message key="profile"/></a>
                <a href="<c:url value="/expositions"/>" class="w3-bar-item w3-button"><fmt:message
                        key="expositions"/></a>
                <a href="<c:url value="/logout"/>" class="w3-bar-item w3-button"><fmt:message key="logout"/></a>
            </div>
        </div>
    </div>

    <!--PAYMENT FORM-->
    <div class="w3-panel w3-center w3-opacity" style="padding:30px 16px 50px 16px">
        <c:choose>
            <c:when test="${sessionScope.result == 'success'}">
                <!--PAYMENT SUCCESS MESSAGE-->
                <div class="w3-panel w3-center" style="padding:64px 16px">
                    <b><h2 class="w3-text-green w3-xxxlarge w3-lobster"><fmt:message key="paymentSuccess"/></h2></b>
                    <b><h2 class="w3-text-green w3-xxlarge w3-lobster"><fmt:message key="checkExpositions"/></h2></b>
                </div>
            </c:when>
            <c:when test="${sessionScope.result == 'fail'}">
                <!--PAYMENT FAIL MESSAGE-->
                <div class="w3-panel w3-center" style="padding:64px 16px">
                    <b><h2 class="w3-text-red w3-xxxlarge w3-lobster"><fmt:message key="paymentFail"/></h2></b>
                    <a class="w3-button w3-black w3-hover-blue" href="<c:url value="/donate"/>"><fmt:message key="tryAgain"/></a>
                </div>
            </c:when>
            <c:otherwise>
                <!--PAYMENT FORM-->
                <form method="post" action="<c:url value="/donate"/>" class="w3-container w3-center"
                      style="max-width: 50%; text-align: center; display: inline-block;">
                    <div class="w3-row-padding" style="margin-bottom: 10px;">
                        <div class="w3-twothird">
                            <b><label class="w3-left"><fmt:message key="owner"/></label></b>
                            <input class="w3-input w3-border" type="text">
                        </div>
                        <div class="w3-third">
                            <b><label class="w3-left"><fmt:message key="cvv"/></label></b>
                            <input class="w3-input w3-border" type="text">
                        </div>
                    </div>
                    <div class="w3-row" style="margin-bottom: 10px;">
                        <div class="w3-container">
                            <b><label class="w3-left"><fmt:message key="card"/></label></b>
                            <input class="w3-input w3-border" type="text">
                        </div>
                    </div>
                    <div class="w3-row" style="margin-bottom: 10px;">
                        <div class="w3-container">
                            <b><label class="w3-left"><fmt:message key="credits"/></label></b>
                            <input name="credits" value="0" class="w3-input w3-border" type="text">
                        </div>
                    </div>
                    <div class="w3-row" style="margin-bottom: 10px;">
                        <div class="w3-container">
                            <b><label class="w3-left"><fmt:message key="expiration"/></label></b>
                        </div>
                    </div>
                    <div class="w3-row-padding" style="margin-bottom: 10px;">

                        <div class=" w3-half">
                            <select class="w3-select">
                                <option value="01">January</option>
                                <option value="02">February</option>
                                <option value="03">March</option>
                                <option value="04">April</option>
                                <option value="05">May</option>
                                <option value="06">June</option>
                                <option value="07">July</option>
                                <option value="08">August</option>
                                <option value="09">September</option>
                                <option value="10">October</option>
                                <option value="11">November</option>
                                <option value="12">December</option>
                            </select></div>
                        <div class=" w3-half">
                            <select class="w3-select w3-third">
                                <option value="16"> 2016</option>
                                <option value="17"> 2017</option>
                                <option value="18"> 2018</option>
                                <option value="19"> 2019</option>
                                <option value="20"> 2020</option>
                                <option value="21"> 2021</option>
                            </select>
                        </div>
                    </div>
                    <div class="w3-row">
                        <div class="w3-container">
                            <input class="w3-button w3-block w3-black w3-hover-blue w3-center" style="padding: 10px 100px;"
                                   type="submit" value="<fmt:message key="confirm" />">
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
