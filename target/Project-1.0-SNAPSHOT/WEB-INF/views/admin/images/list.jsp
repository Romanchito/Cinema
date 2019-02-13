<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>
    <title>Images</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/tableAdminStyle.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>

</head>
<body>

<div class="mainInformBlock">
<div class="informBlock">
<c:if test="${!empty images}">
    <table>
        <tr>
            <th>ID</th>
            <th>Path</th>
            <th>Image</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${images}" var="place">
            <tr>
                <td>${place.id}</td>
                <td>${place.path}</td>
                <td><img src="${place.path}" width="130" height="170"/></td>
                <td>
                    <form action="/admin/images/update/${place.id}" method="get">
                        <input type="submit"  class="btn btn-success" value="EDIT" />
                    </form>
                </td>
                <td>
                    <form:form method="post" action="/admin/images/remove/${place.id}" modelAttribute="image" >
                        <input type="submit"  class="btn btn-danger" value="DEL" />
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>

</c:if>

</div>


<div class="addBlock">
<form:form method="post" action="/admin/images/add" modelAttribute="image" class="form-signin"  >
    <div class="form-group ">
    <form:input type="text" path="path" class="form-control" placeholder="Path*" required="required"/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
    </div>
</form:form>
</div>
</div>
</body>
</html>
