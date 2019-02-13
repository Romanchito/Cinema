<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>CinemaHalls</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="mainInformBlock">

    <div class="informBlock">
<c:if test="${!empty cinema_halls}">
    <table>
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Количество мест</th>
            <th>Количество рядов</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${cinema_halls}" var="cinema_hall">
            <tr>
                <td>${cinema_hall.id}</td>
                <td>${cinema_hall.name}</td>
                <td>${cinema_hall.countOfPlaces}</td>
                <td>${cinema_hall.countOfRows}</td>
                <td>
                    <form action="/admin/cinema_halls/update/${cinema_hall.id}" method="get">
                        <input type="submit" class="btn btn-success" value="EDIT" />
                    </form>
                </td>
                <td>
                    <form:form method="post" action="/admin/cinema_halls/remove/${cinema_hall.id}" modelAttribute="cinemaHall" >
                        <input type="submit" class="btn btn-danger" value="DEL" />
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
    </div>
    <div class="addBlock">
    <form:form method="post" action="/admin/cinema_halls/add" modelAttribute="cinemaHall" class="form-signin">

        <spring:bind path="name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="name" class="form-control" placeholder="Name*" required="required"/>
                <form:errors path="name"/>
            </div>
        </spring:bind>
        <spring:bind path="countOfPlaces">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="countOfPlaces" class="form-control" placeholder="Count of places*" required="required"/>
                <form:errors path="countOfPlaces"/>
            </div>
        </spring:bind>
        <spring:bind path="countOfRows">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="countOfRows" class="form-control" placeholder="Count of rows*" required="required"/>
                <form:errors path="countOfRows"/>
            </div>
        </spring:bind>



        <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>


    </form:form>
    </div>
</div>
</body>
</html>