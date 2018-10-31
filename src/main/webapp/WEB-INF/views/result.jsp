<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<jsp:include page="fragments/header.jsp"/>
<body>



</div>



<section class="main_section">
<div class="container bg-light">

<c:forEach var="rates" items="${searchJieGuoresult}">
        <div class="row">
            <h5 class="col-sm-2">Course ID</h5>
                <div class="col-md-6">
                ${rates.courseID}
                </div>
        <div class="btn-group float-right col-md-auto" role="group">
           <a class="btn btn-info" href="/rates/${rates.courseID}">View Rates</a>
            <a class="btn btn-info" href = "/rate_course/${rates.courseID}">Rate Course</a>
            <a class="btn btn-info" href = "/wiki/${rates.courseID}">CourseWiki</a>
        </div>

        </div>
    <br>


    <div class="row">
        <h6 class="col-sm-2">Course Name</h6>
        <div class="col-sm-10">${rates.courseName}</div>
    </div>
    <br>

    <div class="row">
        <h7 class="col-sm-2">Course Description</h7>
        <div id = "descrip" class="col-sm-10"><span id="desSpan">${rates.courseDescrip}</span></div>
        <%--<script>--%>
            <%--var descrip = document.getElementById("desSpan");--%>
            <%--var descripInfo = descrip.innerHTML;--%>
            <%--var splite = descripInfo.split(" ",5);--%>
            <%--descrip.innerText = splite.toString();--%>
        <%--</script>--%>
    </div>

    <hr>
</c:forEach>


</div>
</section>

<jsp:include page="fragments/footer.jsp"/>
</body>

</html>