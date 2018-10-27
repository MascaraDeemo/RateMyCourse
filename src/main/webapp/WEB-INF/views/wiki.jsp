<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Wiki</title>
    <link rel="stylesheet" href="../../resources/main.css">
</head>
<body>
    <h1>${wiki.courseId}</h1>

    <div id="original-content">
        ${wiki.content}
    </div>

    <button id="edit-btn">Edit Wiki</button>

    <form:form modelAttribute="wiki" method="post" action="/wiki">
        <form:textarea path="content" rows="3" cols="20" value="${wiki.content}" />
        <input type="submit" value="Save Changes" />
    </form:form>

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