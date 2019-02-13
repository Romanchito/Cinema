<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Update Session</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="mainInformBlock">
    <div class="addBlock">
<form:form method="post" action="/admin/sessions/update/${session.id}" modelAttribute="session">


    <form:input style="visibility: hidden" path="id" value="${session.id}"/>
    <spring:bind path="cost">
    <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="text" path="cost" class="form-control" placeholder="Cost*" required="required"/>
        <form:errors path="cost"/>
    </div>
    </spring:bind>


    <div class="form-group ">
        <input type="text" name="sessionDate" class="form-control" placeholder="Date*" required="required"/>
    </div>

    <div class="form-group col-md-4">
        <label>Films</label>
        <select name="films" class="form-control">
            <c:forEach var = "i" items="${films}">
                <option selected value="${i.name}">${i.name}</option>
            </c:forEach>
        </select>
    </div>


    <div class="form-group col-md-4">
        <label>Halls</label>
        <select name="halls" class="form-control">
            <c:forEach var = "i" items="${cinemaHalls}">
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