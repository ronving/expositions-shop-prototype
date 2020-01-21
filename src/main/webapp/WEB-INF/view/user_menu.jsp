<%--
  Created by IntelliJ IDEA.
  User: getlight
  Date: 09.01.2020
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="resources" />

<html lang="${param.lang}">
<head>
    <title>Menu</title>

</head>
<body>

<h1><fmt:message key="welcome" /> USER!</h1>

<a href="<c:url value="/logout"/>">Logout</a>
</body>
</html>

