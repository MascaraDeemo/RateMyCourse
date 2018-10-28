<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Wiki</title>
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
    <link rel="stylesheet" href="../../resources/main.css">
</head>
<body class="wiki-container">
    <h1 class="course-title">${wiki.courseId}</h1>
    <div id="original-content">
        ${wiki.content}
    </div>

    <button id="edit-btn">Edit Wiki</button>

    <form:form modelAttribute="wiki" method="post" action="/wiki/${wiki.id}">
        <form:hidden path="courseId" value="${wiki.courseId}"/>
        <form:hidden path="id" value="${wiki.id}"/>
        <form:textarea path="content" rows="3" cols="20" value="${wiki.content}" />
        <input class="button-success" type="submit" value="Save Changes" />
    </form:form>

    <div>
        <c:forEach var="history" items="${wiki.history}">
            ${history.content}
        </c:forEach>
    </div>

    <script>
        var editBtn = document.getElementById('edit-btn');
        editBtn.addEventListener('click', function() {
            var el = document.getElementById("content");
            el.style.display = 'block';
            el.innerText = document.getElementById('original-content').innerHTML;
        });
    </script>
</body>
</html>