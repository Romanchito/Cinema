<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>

<html>
<head>

    <title>${film.name}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/styleMainPage.css">
    <link rel="stylesheet" href = "/css/orderStyle.css">
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/adminInformStyle.css">
    <link rel="stylesheet" href = "/css/CinimaHallTableStyles.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>
<div class="mainInformBlock">

    <div class="informBlock">
        <div class="screenBlock">ЭКРАН</div>

        <table >
    <c:forEach var = "a" begin = "1" end = "${cinemaHall.countOfRows}">
        <tr>
            <td style="text-align: center;background-color: #0f0f0f;color: #f4f8f6">${a}</td>

            <c:forEach var = "i" begin = "1" end = "${cinemaHall.countOfPlaces}">

                <c:forEach items="${places}" var="pl" >



                   <c:if test="${pl.row == a && pl.number == i && pl.status == 'Занято'}">
                       <td style="background-color: red">${i}</td>
                   </c:if>

                    <c:if test="${pl.row == a && pl.number == i && pl.status != 'Занято'}">
                        <td >${i}</td>
                    </c:if>
                    
                </c:forEach>



            </c:forEach>
        </tr>
    </c:forEach>
</table>


</div>
</div>


<div class="orderBlock">
    <form:form method="post" action="/order/${cinemaHall.id}+${session.id}"  modelAttribute="operation"  >
        <form:input style="visibility: hidden" path="status" value="Бронь"/>
        <div class="form-group col-md-4 , orderPanel" style="width: 100%">
            <label>Rows</label>
            <select name="row" class="form-control">
                <c:forEach var = "i" begin = "1" end="${cinemaHall.countOfRows}">
                    <option selected value="${i}">${i}</option>
                </c:forEach>

            </select>


            <label>Places</label>
            <select name="place" class="form-control">
                <c:forEach var = "i" begin = "1" end="${cinemaHall.countOfPlaces}">
                    <option selected value="${i}">${i}</option>
                </c:forEach>

            </select>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Order</button>

        <h3 style="color: #8f0000">${error}</h3>
        <security:authorize access= "hasAnyRole('ROLE_Admin','ROLE_Cashier', 'ROLE_Buyer')" var= "isUSer"/>
        <c:if test= "${isUSer}">
            <select style="visibility: hidden" name="username" class="form-control">
                    <option selected value="<security:authentication property= "principal.username"/>"/>
            </select>
        </c:if>
        <c:if test= "${not isUSer}">
            <select style="visibility: hidden" name="username" class="form-control">
                <option selected value=""/>
            </select>
        </c:if>

    </form:form>
</div>
</body>
</html>
