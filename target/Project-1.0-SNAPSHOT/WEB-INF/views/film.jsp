<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page session="false" %>

<html>
<head>

    <title>${film.name}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href = "/css/styleMainPage.css">
    <link rel="stylesheet" href = "/css/filmInformStyle.css">
    <link rel="stylesheet" href = "/css/bootstrap.css">

    <%@ include file="parts/header.jsp" %>
</head>
<body>

<div class="container">


            <div class="mainContent">

                    <div class="column">
                        <img width="350" height="500" src="${film.image.path}" class="ccc"/>
                    </div>


                    <div class="filmInformColumn">
                        <h1>${film.name}</h1>
                        </br>
                        <table >
                                <tr>
                                    <td class="type"> Возрастная категория </td>
                                    <td style="text-align: center">
                                        <div style="position: relative">
                                            ${film.age_category}+
                                        </div>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="type"> Длительность </td>
                                    <td style="text-align: center">
                                        <div style="position: relative">
                                            ${film.duration}
                                        </div>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="type"> Описание </td>
                                    <td>
                                        <div style="position: relative">
                                            ${film.description}
                                        </div>
                                    </td>
                                </tr>

                        </table>
                    </div>


                    <div class="sessionColumn">

                        <table>
                            <tr >
                                <th style="text-align: center">Стоимость</th>
                                <th style="text-align: center">Дата</th>
                                <th style="text-align: center">Кинозал</th>
                                <th style="text-align: center"></th>
                            </tr>

                            <c:forEach var ="session" items="${film.sessionList}">
                                <tr>
                                    <td align="center">${session.cost}</td>
                                    <td align="center"><fmt:formatDate  value="${session.date}" pattern="dd-MM-YYYY HH:mm"/></td>
                                    <td align="center">${session.cinemaHall.name}</td>
                                    <td><a class="btn btn-success" href="/order/${session.cinemaHall.id}+${session.id}" >Купить</a> </td>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>
            </div>


</div>




</body>
</html>
