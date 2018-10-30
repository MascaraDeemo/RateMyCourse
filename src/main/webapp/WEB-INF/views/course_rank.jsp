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

<h1>Course Rank</h1>
<div>
    <c:forEach var="course" items="${courses}">
        <div> course rate is: ${course.rate} </div>
        <div>course code is: ${course.courseID}</div>
        <div>course name is: ${course.courseName}</div>
    </c:forEach>
</div>

</body>

<jsp:include page="fragments/footer.jsp"/>
</html>
