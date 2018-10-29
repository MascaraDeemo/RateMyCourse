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
<head>
    <title>Course Rank</title>
</head>
<body>

<h1>Course Rank</h1>
<div>
    <c:forEach var="course" items="${courses}">
        course rate is: ${course.rate}
        course code is: ${course.courseID}
    </c:forEach>
</div>

</body>
</html>
