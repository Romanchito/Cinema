<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href = "/css/styleMainPage.css">
<link rel="stylesheet" href = "/css/filmInformStyle.css">
<link rel="stylesheet" href = "/css/bootstrap.css">
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">LOMO|CINEMA</a>
        </div>

        <div class="navbar-collapse collapse">


            <security:authorize access= "hasAnyRole('ROLE_Admin')" var= "isAdmin"/>
            <security:authorize access= "hasAnyRole('ROLE_Cashier')" var= "isCashier"/>
            <security:authorize access= "hasAnyRole('ROLE_Buyer')" var= "isBuyer"/>
            <c:if test= "${isAdmin}">

                <form action="/admin" method="get" class="navbar-form navbar-right" role="form">
                    <input class="btn btn-info" type="submit" value=<security:authentication property= "principal.username"/>>
                </form>


                <form action="/logout" method="post" class="navbar-form navbar-right" role="form">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <input class="btn btn-danger" type="submit" value="Logout">
                </form>
            </c:if>

            <c:if test= "${isCashier}">

                <form action="/cashier_panel" method="get" class="navbar-form navbar-right" role="form">
                    <input class="btn btn-info" type="submit" value=<security:authentication property= "principal.username"/>>
                </form>


                <form action="/logout" method="post" class="navbar-form navbar-right" role="form">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <input class="btn btn-danger" type="submit" value="Logout">
                </form>
            </c:if>

            <c:if test= "${isBuyer}">

                <form   class="navbar-form navbar-right" role="form">
                    <h4 style="color:#ffffff;"> <security:authentication property= "principal.username"/> </h4>
                </form>


                <form action="/logout" method="post" class="navbar-form navbar-right" role="form">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <input class="btn btn-danger" type="submit" value="Logout">
                </form>
            </c:if>


            <c:if test= "${not isBuyer && not isAdmin && not isCashier}">


                <form action="/logout" method="post" class="navbar-form navbar-right" role="form">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <input class="btn btn-info" type="submit" value="Login">
                </form>
            </c:if>



        </div>
        </div>
    </div>
</div>