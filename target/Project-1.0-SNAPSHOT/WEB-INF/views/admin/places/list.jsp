<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>

    <title>Places</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/placesTableStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="mainInformBlock">
<div class="informBlock">
    <section class="">
    <div class="container-table-places">
<c:if test="${!empty places}">
    <table>
        <thead>
        <tr class="header">
            <th style="color: #ffffff;width: 100px;text-align: center;background-color: #0f0f0f">ID</th>
            <th style="color: #ffffff;width: 100px;text-align: center;background-color: #0f0f0f">Ряд</th>
            <th style="color: #ffffff;width: 100px;text-align: center;background-color: #0f0f0f">Место</th>
            <th style="color: #ffffff;width: 100px;text-align: center;background-color: #0f0f0f">Кинозал</th>
            <th style="color: #ffffff;width: 100px;text-align: center;background-color: #0f0f0f">Статус</th>
            <th style="width: 100px;background-color: #0f0f0f"></th>
            <th style="width: 100px;background-color: #0f0f0f"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${places}" var="place">
            <tr>
                <td style="text-align: center">${place.id}</td>
                <td style="text-align: center">${place.row}</td>
                <td style="text-align: center">${place.number}</td>
                <td style="text-align: center">${place.cinemaHall.name}</td>
                <td style="text-align: center">${place.status}</td>
                <td>
                    <form action="/admin/places/update/${place.id}" method="get">
                        <input  class="btn btn-success" type="submit"  value="EDIT" />
                    </form>
                </td>
                <td>
                    <form:form method="post" action="/admin/places/remove/${place.id}" modelAttribute="place" >
                        <input class="btn btn-danger" type="submit"  value="DEL" />
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</c:if>
    </div>
    </section>
</div>
<div class="addBlock">
<form:form method="post" action="/admin/places/add" modelAttribute="place"  class="form-signin">
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
