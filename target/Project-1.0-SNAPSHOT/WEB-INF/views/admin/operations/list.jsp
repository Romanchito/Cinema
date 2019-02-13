<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Title</title>
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
<c:if test="${!empty operations}">
    <table>
        <tr>
            <th>ID</th>
            <th>Фильм</th>
            <th>Дата</th>
            <th>Стоимость</th>
            <th>Пользователь</th>
            <th>Кассир</th>
            <th>Статус</th>
        </tr>




        <c:forEach items="${operations}" var="operation">
            <tr>
                <td>${operation.id}</td>
                <td>${operation.session.film.name}</td>
                <td>${operation.session.date}</td>
                <td>${operation.session.cost}</td>
               <td>${operation.buyer.id}</td>
                <td>${operation.cashier.name}</td>
                <td>${operation.status}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
    </div>



</div>

</body>
</html>
