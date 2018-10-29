<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <hr>
    <footer>
        <p>&copy; Rate My Course</p>
    </footer>
</div>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/core/js/bootstrap.min.js"
            var="bootstrapJs" />

<script src="${bootstrapJs}"></script>

