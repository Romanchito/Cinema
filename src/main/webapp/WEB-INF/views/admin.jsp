<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" href="/css/mainAdminPanelStyles.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<h3>${welcomeMessage}</h3>
<br>


<div class="mainMenuBlock">
    <div  class="menuBlock"><a href="/admin/sessions">Sessions</a></div>
    <div  class="menuBlock"><a href="/admin/users">Users</a></div>
    <div  class="menuBlock"><a href="/admin/films">Films</a></div>
    <div  class="menuBlock"><a href="/admin/discounts">Discounts</a></div>
    <div  class="menuBlock"><a href="/admin/cinema_halls">Cinema Halls</a></div>
    <div  class="menuBlock"><a href="/admin/operationsOfCinema">Operations</a></div>
    <div  class="menuBlock"><a href="/admin/places">Places</a></div>
    <div  class="menuBlock"><a href="/admin/holders">Holders</a></div>
    <div  class="menuBlock"><a href="/admin/images">Images</a></div>
    <div  class="menuBlock"><a href="/cashier_panel">CashierPanel</a></div>
</div>


</body>
</html>