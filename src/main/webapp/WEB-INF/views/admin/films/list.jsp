<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Films</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">

    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="mainInformBlock">

    <div class="informBlock">
<c:if test="${!empty films}">
    <table>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>DURATION</th>
            <th>Image</th>
            <th>AGE</th>
            <th>DESCRIPTION</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${films}" var="place">
            <tr>
                <td>${place.id}</td>
                <td>${place.name}</td>
                <td>${place.duration}</td>
                <td>${place.image.path}</td>
                <td>${place.age_category}</td>
                <td>${place.description}</td>
                <td>
                    <form action="/admin/films/update/${place.id}" method="get">
                        <input type="submit" class="btn btn-success" value="EDIT" />
                    </form>
                </td>
                <td>
                    <form:form method="post" action="/admin/films/remove/${place.id}" modelAttribute="film" >

                        <input type="submit" class="btn btn-danger" value="DEL" />
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>

</c:if>
    </div>
    <div class="addBlock">
<form:form method="post" action="/admin/films/add" modelAttribute="film" class="form-signin">

    <spring:bind path="name">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="name" class="form-control" placeholder="Name*" required="required"/>
            <form:errors path="name"/>
        </div>
    </spring:bind>
    <spring:bind path="age_category">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="age_category" class="form-control" placeholder="Age category*" required="required"/>
            <form:errors path="age_category"/>
        </div>
    </spring:bind>
    <spring:bind path="duration">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="duration" class="form-control" placeholder="Duration*" required="required"/>
            <form:errors path="duration"/>
        </div>
    </spring:bind>
    <spring:bind path="description">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="description" class="form-control" placeholder="Description*" />
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
