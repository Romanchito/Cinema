<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Update Image</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>

</head>
<body>
<div class="mainInformBlock">
    <div class="addBlock">
<form:form method="post" class="form-singinl" action="/admin/images/update" modelAttribute="image">
<div class="form-group ">
        <form:input style="visibility: hidden" path="id" value="${image.id}"/>
        <form:input type="text" path="path" class="form-control" placeholder="Path*" required="required"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
</div>
</form:form>

    </div>
</div>

</body>
</html>