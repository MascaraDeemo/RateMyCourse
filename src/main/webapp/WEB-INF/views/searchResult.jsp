<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<table>
    <thead>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Description</th>
    </tr>
    </thead>

    <c:forEach var = "course" items = "${searchResult}">
        <tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.courseDescrip}</td>
        </tr>
</table>

</body>
</html>
