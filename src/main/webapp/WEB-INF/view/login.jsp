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
</head>
<body>

<h2>
    <fmt:message key="welcome" />
</h2>
<ul>
    <li><a href="?lang=en"><fmt:message key="lang.en" /></a></li>
    <li><a href="?lang=de"><fmt:message key="lang.de" /></a></li>
    <li><a href="?lang=ru"><fmt:message key="lang.ru" /></a></li>
</ul>

<div class="form">
    <form method="post" action="">
        <input type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="<fmt:message key="signIn" />">
    </form>
</div>
</body>
</html>

