<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<jsp:include page="fragments/header.jsp"/>
<body>
<section class="main_section">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header class="card-header">
                    <h4 class="card-title mt-2">Create a Course</h4>
                </header>
                <article class="card-body">
<div>
    <form:form modelAttribute="Course" method="post" action="/course/add">
        <div class="form-group">
            <label>CourseID</label>
            <form:input cssClass="form-control" type="text" path="courseID" />
        </div>
        <div class="form-group">
            <label>CourseName</label>
            <form:input cssClass="form-control" type="text" path="courseName" />
        </div>
        <div class="form-group">
            <label>Coordinator</label>
            <form:input cssClass="form-control" type="text" path="coordinator"/>
        </div>
        <div class="form-group">
            <label>Description</label>
                <form:input cssClass="form-control" type="text" path="courseDescrip" rows="3" cols="20" />
        </div>
        <button class="btn btn-primary btn-block" id="register" type="submit" value="Save Changes">Save Changes</button>
    </form:form>
                </article>
            </div>
        </div>
    </div>
</section>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>
