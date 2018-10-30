<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="fragments/header.jsp"/>
<body>

<section class="main_section">
  <br><br><br><br><br><br><br>

<div class="container">
  <br>
  <div class="row justify-content-center">
    <div class="col-12 col-md-10 col-lg-8">
      <form class="card card-sm">
        <div class="card-body row no-gutters align-items-center">
          <div class="col-auto">
            <i class="fas fa-search h4 text-body"></i>
          </div>

          <!--end of col-->
          <form action="/sousuo">
          <div class="col">
            <input class="form-control form-control-lg form-control-borderless" name="search" type="search" placeholder="Search topics or keywords">
          </div>
          <!--end of col-->
          <div class="col-auto">
            <button class="btn btn-lg btn-success" type="submit">Search</button>
          </div>
          </form>
          <!--end of col-->
        </div>
      </form>
    </div>
    <!--end of col-->
  </div>

  </div>

  <br><br><br><br><br><br><br><br><br><br>
</section>

<jsp:include page="fragments/footer.jsp"/>


</body>
</html>
