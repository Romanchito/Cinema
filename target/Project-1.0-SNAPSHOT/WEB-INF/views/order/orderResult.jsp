<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Result Order</title>
    <link rel="stylesheet" href = "/css/bootstrap.css">
    <link rel="stylesheet" href = "/css/AuthStyles.css">
    <%@ include file="/WEB-INF/views/parts/header.jsp" %>
</head>
<body>

<div class="container">

    <div class="authContainer">
        <form method="GET" action="/" class="form-signin">
            <h2 class="form-heading" style="text-align: center">THANKS FOR ORDER!</h2>
            YOUR COD <strong style="font-size: 50px">${code}</strong>  DONT FORGOT IT!
            <h2>ROW: ${row} PLACE: ${place}</h2>


                <button class="btn btn-lg btn-primary btn-block" type="submit">Home</button>


        </form>

    </div>

</div>

</body>
</html>
