<%--
  Created by IntelliJ IDEA.
  User: getlight
  Date: 23.01.2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="resources"/>
<footer class="w3-container w3-padding-16 w3-light-grey w3-center w3-large w3-lobster w3-opacity">
    <div class="w3-padding-16">
        <div class="w3-bar">
            <a href="?lang=ru" class="w3-bar-item w3-button"><fmt:message key="lang.ru"/></a>
            <a href="?lang=en" class="w3-bar-item w3-button w3-light-grey"><fmt:message key="lang.en"/></a>
            <a href="?lang=de" class="w3-bar-item w3-button"><fmt:message key="lang.de"/></a>
        </div>
    </div>
</footer>
