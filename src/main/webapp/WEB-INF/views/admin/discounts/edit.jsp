<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>

    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
    <title>Update Discount</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>

</head>
<body>

<div class="mainInformBlock">
    <div class="addBlock">
<form:form method="post" action="/admin/discounts/update/${discount.id}" modelAttribute="discount">

        <form:input style="visibility: hidden" path="id" value="${discount.id}"/>
            <spring:bind path="percent">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="percent" class="form-control" placeholder="Percent*" required="required" value="${discount.percent}"/>
                <form:errors path="percent"/>
            </div>
            </spring:bind>
    <div class="form-group ">
        <input type="text" name="discountDate" class="form-control" placeholder="Date*" required="required"/>
    </div>
    ${errorMessage}


            <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
</form:form>
    </div>
</div>
</body>
</html>