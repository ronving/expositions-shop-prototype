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

        .w3-quarter img {
            opacity: 0.7;
            margin-bottom: -6px;
            cursor: pointer
        }

        .w3-quarter img:hover {
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
        <div class="w3-col s6 w3-opacity-min w3-center">
            <!--HALL DETAILS-->
            <div class="w3-row-padding w3-grayscale-min">
                <h1 class="w3-lobster w3-jumbo"><b>${sessionScope.hall.getTheme()}</b></h1>
                <h2 class="w3-xxlarge"><b><fmt:message key="dateFrom"/>: </b><span class="w3-lobster w3-text-blue">${sessionScope.hall.getDateFrom()}</span></h2>
                <h2 class="w3-xxlarge"><b><fmt:message key="dateTo"/>: </b><span class=" w3-text-blue w3-lobster">${sessionScope.hall.getDateTo()}</span></h2>
                <h3 class="w3-xlarge"><b><fmt:message key="description"/>: </b>${sessionScope.hall.getDescription()}</h3><br>
                <form action="<c:url value="/order"/>" method="post">
                    <input class="w3-button w3-red w3-xxlarge w3-lobster" type="submit" value="<fmt:message key="buy"/>" />
                </form>
            </div>
        </div>

        <!--HALL -->
        <div class="w3-col s6 w3-center w3-padding-16">
            <img class="w3-card-4" src="${pageContext.request.contextPath}${sessionScope.hall.getImgURL()}" style="width:95%">
        </div>
    </div>

    <!--EXPOSITIONS GRID-->
    <div class="w3-row w3-center">
        <h1 class="w3-center"><b><fmt:message key="expoFromHall"/></b></h1>
        <c:forEach var="expo" items="${sessionScope.expositions}">
            <div class="w3-quarter w3-center">
                <div class="w3-container w3-margin w3-card">
                <img src="${pageContext.request.contextPath}${expo.getImgURL()}" style="width:95%"
                     onclick="onClick(this, '${expo.getTitle()}', '${expo.getDescription()}')"
                     alt="${hall.getTheme()}">
                <h2>${expo.getTitle()}</h2>
                </div>
            </div>
        </c:forEach>
    </div>

    <!--MODAL FOR IMAGES ON CLICK-->
    <div id="modal" class="w3-modal w3-white" style="padding-top:0" onclick="this.style.display='none'">
        <span class="w3-button w3-black w3-xxlarge w3-display-topright">×</span>
        <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
            <img id="img" class="w3-image">
            <b><h1 id="title" class="w3-lobster w3-xxxlarge"></h1></b><br>
            <h3 id="description" class="w3-lobster"></h3>
        </div>
    </div>

    <!--FOOTER-->
    <c:import url="parts/footer.jsp"/>
</div>

<!--FULLSCREEN GALLERY ON CLICK-->
<script>
    // Modal Image Gallery
    function onClick(element, title, description) {
        document.getElementById("img").src = element.src;
        document.getElementById("modal").style.display = "block";
        var titleText = document.getElementById("title");
        var descriptionText = document.getElementById("description");
        titleText.innerHTML = title;
        descriptionText.innerHTML = description;
    }
</script>
</body>
</html>
