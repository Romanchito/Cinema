<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>
<html>
<head>

    <title>Cashier panel</title>
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
                    <th>Дата</th>
                    <th>Статус</th>
                    <th>ПромоКод</th>
                    <th></th>
                </tr>

                <c:forEach items="${operations}" var="operation">
                    <c:if test="${operation.status == 'Бронь'}">
                    <tr>
                        <td>${operation.id}</td>
                        <td>${operation.date}</td>
                        <td>${operation.status}</td>
                        <td>${operation.code}</td>
                        <td>
                            <form:form method="post" action="cashier_panel/update/${operation.id}" modelAttribute="operation" >


                                <security:authorize access= "hasAnyRole('ROLE_Admin','ROLE_Cashier', 'ROLE_Buyer')" var= "isUSer"/>
                                <c:if test= "${isUSer}">
                                    <select style="visibility: hidden" name="username" class="form-control">
                                        <option selected value="<security:authentication property= "principal.username"/>"/>
                                    </select>
                                </c:if>


                                <input class="btn btn-success" type="submit"  value="ADD" />
                            </form:form>

                        </td>
                    </tr>
                    </c:if>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>

</body>
</html>