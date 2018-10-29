<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<head>
    <title>Create A Course</title>
</head>
<body>

<h1>Create A Course</h1>
<div>
    <form:form modelAttribute="Course" method="post" action="/course/add">
       CourseID: <form:input type="text" path="courseID" />
       CourseName: <form:input type="text" path="courseName" />
       Coordinator: <form:input type="text" path="coordinator"/>
        Description: <form:input type="text" path="courseDescrip" rows="3" cols="20" />
        <input class="button-success" type="submit" value="Save Changes" />
    </form:form>
</div>

</body>
</html>
