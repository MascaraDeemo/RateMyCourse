<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Rate My Course</title>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />

</head>

<spring:url value="/search" var="urlSearch" />

<div class="wrapper">
<nav class="navbar navbar-expand-md">
    <a class="navbar-brand" href="/search">Rate My Course</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/search">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Top Rated Course</a>
            </li>
        </ul>
    </div>

</nav>
</div>
