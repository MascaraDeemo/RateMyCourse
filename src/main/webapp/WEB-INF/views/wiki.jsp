<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="fragments/header.jsp" />

<body class="wiki-container">

  <section class="main_section">
    <div class="container">
      <!-- <div class="col-12 col-md-10 col-lg-8"> -->
      <!-- <div class="card card-sm"> -->
      <!-- <div class="card-body row no-gutters align-items-center"> -->
      <div class="wiki-container">
        <h1 class="course-title">${wiki.courseId} ${wiki.courseName}</h1>
        <div id="original-content">
          ${wiki.content}
        </div>

        <form:form id="wiki-form" modelAttribute="wiki" method="post" action="/wiki/${wiki.id}">
          <form:hidden path="courseId" value="${wiki.courseId}" />
          <form:hidden path="id" value="${wiki.id}" />
          <form:textarea path="content" rows="3" cols="20" value="${wiki.content}" />
          <div class="submit-container">
            <form:input path="summary" type="text" placeholder="Summary of this edition" value="" />
            <input class="button-success" type="submit" value="submit" />
          </div>
        </form:form>



        <button id="edit-btn">Edit Wiki</button>

        <div class="history-list">
          <h3>Wiki Edit Revision</h3>
          <ol>
            <c:forEach var="history" items="${wiki.history}">
              <li>
                <span class="history-modified-time">This Wiki was modified at: ${history.time}</span>
                <span class="history-content">The content is: ${history.content}</span>
                <span class="history-summary">summarized as: ${history.summary}</span>
              </li>
              <br />
            </c:forEach>
          </ol>
        </div>
      </div>
      <!-- </div> -->
      <!-- </div> -->
    </div>
  </section>


  <script>
    var editBtn = document.getElementById('edit-btn');
    editBtn.addEventListener('click', function () {
      var form = document.getElementById('wiki-form');
      if (form.style.display !== 'block') {
        form.style.display = 'block';
      } else {
        form.style.display = 'none';
        return;
      }
      var el = document.getElementById("content");
      el.innerText = document.getElementById('original-content').innerHTML;
      document.getElementById('summary').value = "";
    });
  </script>

  <jsp:include page="fragments/footer.jsp" />
  <link rel="stylesheet" href="/resources/core/css/wiki.css">
</body>

</html>