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
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="resources"/>

<html>
<head>
    <title>Login</title>
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

    <div class="w3-panel w3-center w3-opacity" style="padding:30px 16px 50px 16px">
        <h2>
            <b><fmt:message key="welcome"/></b><br>
        </h2>


            <form method="post" class="w3-container w3-center" style="width: 25%; text-align: center; display: inline-block;">
                <input class="w3-input w3-border w3-center" style="margin-bottom: 5px;" type="text" required placeholder="<fmt:message key="login"/>" name="login">
                <input class="w3-input w3-border w3-center" type="password" required placeholder="<fmt:message key="password"/>" name="password"><br>
                <input class="w3-btn w3-blue w3-center" type="submit" value="<fmt:message key="signIn" />">
            </form>

    </div>

    <c:import url="parts/footer.jsp"/>
</div>
</body>
</html>

