<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Sessions</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="mainInformBlock">
    <div class="informBlock">
<c:if test="${!empty sessions}">
    <table>
        <tr>
            <th>ID</th>
            <th>Фильм</th>
            <th>Зал</th>
            <th>Дата</th>
            <th>Стоимость</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${sessions}" var="session">
            <tr>
                <td>${session.id}</td>
                <td>${session.film.name}</td>
                <td>${session.cinemaHall.name}</td>
                <td><fmt:formatDate  value="${session.date}" pattern="dd-MM-YYYY HH:mm"/></td>
                <td>${session.cost}</td>
                <td>
                    <form action="/admin/sessions/update/${session.id}" method="get">
                        <input type="submit" class="btn btn-success" value="EDIT" />
                    </form>
                </td>
                <td>
                    <form:form method="post" action="/admin/sessions/remove/${session.id}" modelAttribute="session" >
                        <input type="submit" class="btn btn-danger" value="DEL" />
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
    </div>



<div class="addBlock">
<form:form method="post" action="/admin/sessions/add"  modelAttribute="session" class="form-signin">

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