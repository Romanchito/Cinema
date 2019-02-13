<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Update Film</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>
<div class="mainInformBlock">
    <div class="addBlock">
<form:form method="post" action="/admin/films/update/${film.id}" modelAttribute="film">


        <form:input style="visibility: hidden" path="id" value="${film.id}"/>
        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="Name*" required="required" value="${film.name}"/>
                <form:errors path="name"/>
            </div>
        </spring:bind>
        <spring:bind path="age_category">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="age_category" class="form-control" placeholder="Age category*" required="required" value="${film.age_category}"/>
                <form:errors path="age_category"/>
            </div>
        </spring:bind>
        <spring:bind path="duration">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="duration" class="form-control" placeholder="Duration*" required="required" value="${film.duration}"/>
                <form:errors path="duration"/>
            </div>
        </spring:bind>
        <spring:bind path="description">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="description" class="form-control" placeholder="Description*" value="${film.description}"/>
                <form:errors path="description"/>
            </div>
        </spring:bind>

    <div class="form-group col-md-4">
        <label>Films</label>
        <select name="images" class="form-control">
            <c:forEach var = "i" items="${images}">
                <option selected value="${i.id}">${i.path}</option>
            </c:forEach>
        </select>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
</form:form>

    </div>
</div>

</body>
</html>