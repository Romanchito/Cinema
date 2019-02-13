<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<html>
<head>
    <title>Discounts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="mainInformBlock">
<div class="informBlock">
<c:if test="${!empty discounts}">
    <table>
        <tr>
            <th>ID</th>
            <th>Процент</th>
            <th>Конечная дата</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${discounts}" var="discount">
            <tr>
                <td>${discount.id}</td>
                <td>${discount.percent}</td>
                <td><fmt:formatDate  value="${discount.endDate}" pattern="dd-MM-YYYY"/></td>
                <td>
                    <form action="/admin/discounts/update/${discount.id}" method="get">
                        <input type="submit" class="btn btn-success" value="EDIT" />
                    </form>
                </td>
                <td>
                    <form:form method="post" action="/admin/discounts/remove/${discount.id}" modelAttribute="discount" >
                        <input type="submit" class="btn btn-danger" value="DEL" />
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</div>


<div class="addBlock">
    <form:form method="post" action="/admin/discounts/add" modelAttribute="discount" class="form-signin">
        <spring:bind path="percent">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="percent" class="form-control" placeholder="Percent*" required="required"/>
                <form:errors path="percent"/>
            </div>
        </spring:bind>
        <div class="form-group ">
            <input type="text" name="discountDate" class="form-control" placeholder="Date*" required="required"/>
        </div>
        ${errorMessage}

        <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
    </form:form>


    </div>
</div>

</body>
</html>