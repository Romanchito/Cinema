<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>

    <title>Admin users</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">

    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="mainInformBlock">

<div class="informBlock">
    <c:if test="${!empty users}">
    <table>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Отчество</th>
            <th>Роль</th>
            <th>Логин</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${users}" var="discount">
            <tr>
                <td>${discount.id}</td>
                <td>${discount.name}</td>
                <td>${discount.surname}</td>
                <td>${discount.patronymic}</td>
                <td>${discount.role}</td>
                <td>${discount.email}</td>

                <td>
                    <form action="/admin/users/update/${discount.id}" method="get">
                        <input class="btn btn-success" type="submit"  value="EDIT" />
                    </form>
                </td>
                <td>
                    <form:form method="post" action="/admin/users/remove/${discount.id}" modelAttribute="user" >
                        <input class="btn btn-danger" type="submit"  value="DEL" />
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</div>


<div class="addBlock">
    <form:form method="post" modelAttribute="user" action="/admin/users/add" class="form-signin">

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="Name*" />
                <form:errors path="name"/>
            </div>
        </spring:bind>


        <spring:bind path="surname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="surname" class="form-control" placeholder="Surname*" autofocus="true"/>
                <form:errors path="surname"/>
            </div>
        </spring:bind>

        <spring:bind path="patronymic">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="patronymic" class="form-control" placeholder="Patronymic" autofocus="true"/>
                <form:errors path="patronymic"/>
            </div>
        </spring:bind>


        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="email" class="form-control" placeholder="Email*" autofocus="true"/>
                <form:errors path="email"/>
            </div>
        </spring:bind>


        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"/>
                <form:errors path="password"/>
            </div>
        </spring:bind>


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


        <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>

    </form:form>
</div>
</div>

</body>
</html>