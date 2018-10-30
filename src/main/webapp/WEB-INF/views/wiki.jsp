<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="fragments/header.jsp"/>
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
        <form:input path="summary" type="text" placeholder="Summary of this edition" />
        <input class="button-success" type="submit" value="Save Changes" />
    </form:form>

    <div>
        <c:forEach var="history" items="${wiki.history}">
            content: ${history.content}
            summary: ${history.summary}
            modified at: ${history.time}
            <br />
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

    <jsp:include page="fragments/footer.jsp"/>
</body>

</html>