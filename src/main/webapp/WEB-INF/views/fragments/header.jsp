<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <title>Spring MVC Form Handling Example</title>
    <spring:url value="/resources/css/hello.css" var="coreCss" />
    <spring:url value="/resources/css/bootstrap.min.css"
                var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
</head>
<spring:url value="/" var="urlHome" />
<spring:url value="/login" var="urlLogin" />

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Rate My Course</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlLogin}">Login/Register</a></li>
            </ul>
        </div>
    </div>

</nav>

