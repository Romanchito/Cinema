<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Update CinemaHall</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="mainInformBlock">
    <div class="addBlock">
<form:form method="post" action="/admin/cinema_halls/update/${cinemaHall.id}" modelAttribute="cinemaHall">
        <form:input style="visibility: hidden" path="id" value="${cinemaHall.id}"/>
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="Name*" required="required"  value="${cinemaHall.name}"/>
                <form:errors path="name"/>
            </div>
            </spring:bind>
            <spring:bind path="countOfPlaces">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="countOfPlaces" class="form-control" placeholder="Count of places*" required="required"  value="${cinemaHall.countOfPlaces}"/>
                <form:errors path="countOfPlaces"/>
            </div>
            </spring:bind>
            <spring:bind path="countOfRows">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="countOfRows" class="form-control" placeholder="Count of rows*" required="required"  value="${cinemaHall.countOfRows}"/>
                <form:errors path="countOfRows"/>
            </div>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
</form:form>
    </div>
</div>

</body>
</html>