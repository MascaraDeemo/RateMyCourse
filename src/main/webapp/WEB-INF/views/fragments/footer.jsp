<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<footer class="page-footer font-small">

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2018 Copyright:
        <a href="https://mdbootstrap.com/bootstrap-tutorial/"> RateMyCourse.com</a>
    </div>
    <!-- Copyright -->

</footer>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/core/js/bootstrap.min.js"
            var="bootstrapJs" />

<script src="${bootstrapJs}"></script>

