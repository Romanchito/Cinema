<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>Update User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">

    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>
<div class="mainInformBlock">
<div class="addBlock">
    <h1>${mm}</h1>
<form:form method="post" modelAttribute="user" action="/admin/users/update/${user.id}" class="form-signin " >

    <form:input style="visibility: hidden" path="id" value="${user.id}"/>
    <spring:bind path="name">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="name"  class="form-control" placeholder="Name*" value="${user.name}"  required="required"/>
            <form:errors path="name"/>
        </div>
    </spring:bind>


    <spring:bind path="surname">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="surname" class="form-control" placeholder="Surname*" value="${user.surname}"/>
            <form:errors path="surname"/>
        </div>
    </spring:bind>

    <spring:bind path="patronymic">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="patronymic" class="form-control" placeholder="Patronymic" value="${user.patronymic}"/>
            <form:errors path="patronymic"/>
        </div>
    </spring:bind>


    <spring:bind path="email">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="email" class="form-control" placeholder="Email*" value="${user.email}"/>
            <form:errors path="email"/>
        </div>
    </spring:bind>


    <form:input style="visibility: hidden"  type="password" path="password" class="form-control" placeholder="Password" value="${user.password}"/>


    <spring:bind path="role">
        <div class="form-group col-md-4">
            <label>Roles</label>
            <select name="roles" class="form-control">
                <option selected>Buyer</option>
                <option>Cashier</option>
                <option>Admin</option>
            </select>
        </div>
    </spring:bind>



    <button class="btn btn-lg btn-success btn-block" type="submit">Update</button>
    <a class= "btn btn-lg btn-danger btn-block" href="/admin/users" role="button">Back</a>

</form:form>
</div>
</div>

</body>
</html>