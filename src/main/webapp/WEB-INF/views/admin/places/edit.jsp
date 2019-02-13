<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Update Place</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>
<div class="mainInformBlock">
    <div class="addBlock">
<form:form method="post" action="/admin/places/update/${place.id}" modelAttribute="place">

        <form:input style="visibility: hidden" path="id" value="${place.id}"/>
        <form:input style="visibility: hidden" path="status" value="${place.status}"/>
            <spring:bind path="number">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="number" class="form-control" placeholder="Number*" required="required"/>
                <form:errors path="number"/>
            </div>
            </spring:bind>


            <spring:bind path="row">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="row" class="form-control" placeholder="Row*" required="required"/>
                <form:errors path="row"/>
            </div>
            </spring:bind>

            <div class="form-group col-md-4">
                <label>Halls</label>
                <select name="halls" class="form-control">
                    <c:forEach var = "i" items="${halls}">
                        <option selected value="${i.name}">${i.name}</option>
                    </c:forEach>
                </select>
            </div>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
</form:form>
    </div>
</div>


</body>
</html>