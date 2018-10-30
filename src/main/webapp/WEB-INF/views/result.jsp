<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<jsp:include page="fragments/header.jsp"/>
<body>

<div>
    <form action="/sousuo">
        <input type="text" placeholder="Search.." name="search">
        <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>


<h1>Search Result</h1>

<hr>
<c:forEach var="rates" items="${searchJieGuoresult}">
    <div class="row">
        <label class="col-sm-2">Course ID</label>
        <div class="col-sm-10">${rates.courseID}</div>
        <div class="column">
            <button type="button" class="btn btn-info"><a href="/rates/${rates.courseID}">View Rates</a></button>
            <button type="button" class="btn btn-info"><a href = "/rate_course/${rates.courseID}">Rate Course</a></button>
            <button type="button" class="btn btn-info"><a href = "/wiki/${rates.courseID}">CourseWiki</a></button>

        </div>

    </div>

    <div class="row">
        <label class="col-sm-2">Course Name</label>
        <div class="col-sm-10">${rates.courseName}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Course Description</label>
        <div id = "descrip" class="col-sm-10"><span id="desSpan">${rates.courseDescrip}</span></div>
        <script>
            var descrip = document.getElementById("desSpan");
            var descripInfo = descrip.innerHTML;
            var splite = descripInfo.split(" ",5);
            descrip.innerText = splite.toString();
        </script>
    </div>
    <hr>
</c:forEach>

<jsp:include page="fragments/footer.jsp"/>
</body>

</html>