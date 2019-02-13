<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Holders</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="mainInformBlock">
<div class="informBlock">
<c:if test="${!empty holders}">
    <table>
        <tr>
            <th>ID</th>
            <th>User</th>
            <th>Percent</th>
            <th></th>
        </tr>

        <c:forEach items="${holders}" var="holder">
            <tr>
                <td>${holder.id}</td>
                <td>${holder.user.name}</td>
                <td>${holder.discount.percent}</td>
                <td>
                    <form:form method="post" action="/admin/holders/remove/${holder.id}" modelAttribute="holder" >

                        <input type="submit"  class="btn btn-danger" value="DEL" />
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</div>
<div class="addBlock">
<form:form method="post" action="/admin/holders/add"  modelAttribute="holder" >

    <div class="form-group col-md-4">
        <label>Discounts</label>
        <select name="discounts" class="form-control">
            <c:forEach var = "i" items="${discounts}">
                <option selected value="${i.id}">${i.percent}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group col-md-4">
        <label>Users</label>
        <select name="users" class="form-control">
            <c:forEach var = "i" items="${users}">
                <option selected value="${i.id}">${i.name}</option>
            </c:forEach>
        </select>
    </div>


    <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
</form:form>
</div>
</div>
</body>
</html>