<%--
  Created by IntelliJ IDEA.
  User: getlight
  Date: 29.01.2020
  Time: 11:27
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
<html>
<head>
    <title>Hall Details</title>
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
        <h1><fmt:message key="details"/></h1>

        <div class="w3-padding-32">
            <div class="w3-bar w3-border">
                <a href="<c:url value="/profile"/>" class="w3-bar-item w3-button"><fmt:message key="profile"/></a>
                <a href="<c:url value="/expositions"/>" class="w3-bar-item w3-button w3-light-grey"><fmt:message
                        key="expositions"/></a>
                <a href="<c:url value="/logout"/>" class="w3-bar-item w3-button"><fmt:message key="logout"/></a>
            </div>
        </div>
    </div>

    <!--HALL INFO-->
    <div class="w3-row">
        <!--EXPOSITIONS GRID-->
        <div class="w3-col s9 w3-opacity w3-center">
            <!--PHOTO-->
            <div class="w3-row-padding w3-grayscale-min">
                <div class="w3-row">
                    <c:forEach var="expo" items="${sessionScope.expositions}">
                        <div class="w3-half">
                            <img src="${expo.getImgURL()}" style="width:100%"
                                 onclick="onClick(this, '${expo.getTitle()}', '${expo.getTheme()}', '${expo.getDescription()}')"
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
                    <b><h1 id="title" class="w3-lobster w3-xxxlarge"></h1></b><br>
                    Theme: <h3 id="theme" class="w3-lobster"></h3>
                    <h3 id="description" class="w3-lobster"></h3>
                </div>
            </div>
        </div>

        <!--HALL -->
        <div class="w3-col s3 w3-opacity w3-center w3-padding-16" style="max-height: 100%">
            <img src="${sessionScope.hall.getImgURL()}" style="width:95%">
            <h2 class="w3-lobster"><b>${sessionScope.hall.getTheme()}</b></h2>
            <h4><b>Date From: </b>${sessionScope.hall.getDateFrom()}</h4>
            <h4><b>Date To: </b>${sessionScope.hall.getDateTo()}</h4>
            <h5><b>Description: </b>${sessionScope.hall.getDescription()}</h5>
            <h3 class="w3-bottom"><b>Ticket Price: </b>${sessionScope.hall.getTicketPrice()}</h3>
        </div>
    </div>

    <!--FOOTER-->
    <c:import url="parts/footer.jsp"/>
</div>

<!--FULLSCREEN GALLERY ON CLICK-->
<script>
    // Modal Image Gallery
    function onClick(element, title, theme, description) {
        document.getElementById("img").src = element.src;
        document.getElementById("modal").style.display = "block";
         var titleText = document.getElementById("title");
         var themeText = document.getElementById("theme");
         var descriptionText = document.getElementById("description");
         titleText.innerHTML = title;
         themeText.innerHTML = theme;
         descriptionText.innerHTML = description;
    }
</script>
</body>
</html>
