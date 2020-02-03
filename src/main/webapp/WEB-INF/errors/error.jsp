<%--
  Created by IntelliJ IDEA.
  User: getlight
  Date: 25.01.2020
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title>Error</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/w3.css">
</head>
<body>
<div class="w3-panel w3-center" style="padding:256px 16px">
    <!--ERROR-->
    <h1 class="w3-xxxlarge w3-text-red"><b><fmt:message key="errorPage"/></b></h1>
</div>
</body>
</html>
