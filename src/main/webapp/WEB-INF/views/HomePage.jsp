<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>

<html>
<head>
    <title>Home Page</title>

    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/styleMainPage.css">
    <link rel="stylesheet" href = "/css/filmInformStyle.css">
    <link rel="stylesheet" href = "/css/bootstrap.css">

    <%@ include file="parts/header.jsp" %>
</head>
<body>

<div class="container">
    <div class="content">
        <div class="mainContent">
            <c:forEach var = "i" items="${films}">

                <div class="column"> <a href="/film/${i.id}" target="_blank"> <img class="infoImg" width="220" height="350" src="${i.image.path}"/></a>
                </div>

            </c:forEach>

        </div>



    </div>

    <%@ include file="parts/footer.jsp" %>
</div>


</body>
</html>


