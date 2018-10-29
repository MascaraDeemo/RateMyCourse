<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="fragments/header.jsp"/>
<body>


<main role="main" class="container">
  <div class="jumbotron jumbotron-fluid">
    <br><br><br><br><br><br><br><br><br>
<div class="container">
  <form action="/sousuo">
    <input class="form-control my-0 py-1" type="text" placeholder="Search.." name="search">
    <div class="input-group-append">
    <button type="submit" class=""><i class="fa fa-search text-grey" aria-hidden="true"></i></button>
    </div>
  </form>
</div>
  </div>
</main>
<jsp:include page="fragments/footer.jsp"/>

<%--<c:forEach var="userList" items = "${userList}">--%>
  <%--<B--%>
<%--</c:forEach>--%>
</body>
</html>
