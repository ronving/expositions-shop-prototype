<%--
  Created by IntelliJ IDEA.
  User: getlight
  Date: 25.01.2020
  Time: 12:29
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
    <title>Expositions</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster">
    <style>
        .w3-lobster {
            font-family: "Lobster", serif;
        }

        .w3-half img {
            opacity: 0.7;
            margin-bottom: -6px;
            cursor: pointer
        }

        .w3-half img:hover {
            opacity: 1;
            transition: 0.3s
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
        <h1><fmt:message key="expositions"/></h1>

        <div class="w3-padding-32">
            <div class="w3-bar w3-border">
                <a href="<c:url value="/profile"/>" class="w3-bar-item w3-button"><fmt:message key="profile"/></a>
                <a href="<c:url value="/expositions"/>" class="w3-bar-item w3-button w3-light-grey"><fmt:message
                        key="expositions"/></a>
                <a href="<c:url value="/logout"/>" class="w3-bar-item w3-button"><fmt:message key="logout"/></a>
            </div>
        </div>
    </div>

    <!--PAGINATION-->
    <div class="w3-center w3-opacity w3-padding-16">
        <div class="w3-bar">
            <c:if test="${currentPage != 1}">
                <a href="?page=${currentPage - 1}" class="w3-bar-item w3-button">&laquo;</a>
            </c:if>

            <c:forEach begin="1" end="${sessionScope.pages}" var="i">
                <c:choose>
                    <c:when test="${sessionScope.currentPage eq i}">
                        <a href="" class="w3-button w3-light-gray">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="?page=${i}" class="w3-button">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt pages}">
                <a href="?page=${currentPage + 1}" class="w3-button">&raquo;</a>
            </c:if>
        </div>
    </div>

    <!--HALLS GRID-->
    <div class="w3-container">
        <!--PHOTO-->
        <div class="w3-row w3-grayscale-min">
            <div class="w3-row">
                <c:forEach var="hall" items="${sessionScope.halls}">
                    <div class="w3-half">
                        <img src="${pageContext.request.contextPath}${hall.getImgURL()}" style="width:100%"
                             onclick="onClick(this, ${hall.getId()}, '${hall.getDescription()}')"
                             alt="${hall.getTheme()}">
                    </div>
                </c:forEach>
            </div>
        </div>

        <!--MODAL FOR IMAGES ON CLICK-->
        <div id="modal" class="w3-modal w3-black" style="padding-top:0" onclick="this.style.display='none'">
            <span class="w3-button w3-black w3-xxlarge w3-display-topright">×</span>
            <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
                <img id="img" class="w3-image">
                <b><h1 id="theme" class="w3-lobster"></h1></b><br>
                <h3 id="details" class="w3-lobster"></h3>
                <form action="<c:url value="/hall"/>" method="post">
                    <input id="info" type="hidden" name="id"/>
                    <input class="w3-button w3-red" type="submit" value="<fmt:message key="check"/>"/>
                </form>
            </div>
        </div>
    </div>

    <!--FOOTER-->
    <c:import url="parts/footer.jsp"/>
</div>

<!--FULLSCREEN GALLERY ON CLICK-->
<script>
    // Modal Image Gallery
    function onClick(element, hallId, description) {
        document.getElementById("img").src = element.src;
        document.getElementById("modal").style.display = "block";
        document.getElementById("info").value = hallId;
        var themeText = document.getElementById("theme");
        var detailsText = document.getElementById("details");
        themeText.innerHTML = element.alt;
        detailsText.innerHTML = description;
    }
</script>
</body>
</html>
