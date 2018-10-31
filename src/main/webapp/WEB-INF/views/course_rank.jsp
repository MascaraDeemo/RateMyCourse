<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: StanFeng
  Date: 2018/10/29
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<jsp:include page="fragments/header.jsp"/>
<body>
<section class="main_section">
    <div class="container bg-light">

        <br>
<div class="row">
    <h2>Course Rank</h2>
</div>
        <hr>
    <c:forEach var="course" items="${courses}">
        <div class="row">
            <label class="col-sm-4">Course Rate is</label>
            <div class="col-sm-8">${course.rate}</div>
        </div>
        <div class="row">
            <label class="col-sm-4">Course Code is</label>
            <div class="col-sm-8">${course.courseID}</div>
        </div>
        <div class="row">
            <label class="col-sm-4">Course Name is</label>
            <div class="col-sm-8">${course.courseName}</div>
        </div>
        <hr>
    </c:forEach>

    <a href="/course/addform">Add a Course</a>
</div>
    </div>

</section>
</body>

<jsp:include page="fragments/footer.jsp"/>
</html>
