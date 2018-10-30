<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragments/header.jsp"/>
<style>
    .book-list {
        list-style: none;
    }

    .book-list li {
        list-style: none;
    }

    .book-list ul {
        padding-left: 0;
    }
</style>
<body>

<section class="main_section">
    <div class="container parent-container bg-light">
        <div class="container col-sm-6 bg-light">
            <br>
        <div class="row">
            <h4>Course Description</h4>
            <div>${descrip}</div>
        </div>
        <br>
            <div class="row">
<h5 class="col-sm-5">Average Difficulty:</h5>
<div class="col-sm-2">${averageDiff}</div>
            </div>
            <br>
            <div class="row">
<h5 class="col-sm-5">Average Rating:</h5>
<div class="col-sm-2">${averageRate}</div>
            </div>

<hr>
<c:forEach var="rates" items="${rates}">
    <div class="row">


        <label class="col-sm-4">Rating</label>
        <div class="col-sm-8">${rates.rating}</div>
    </div>

    <div class="row">
        <label class="col-sm-4">Difficulty</label>
        <div class="col-sm-8">${rates.difficulty}</div>
    </div>




<c:if test="${not empty rates.isIfCredit()}">
    <div class="row" id="creditDiv">
        <label class="col-sm-4">Take For Credit?</label>
        <div class="col-sm-8">${rates.isIfCredit()}</div>
    </div>
</c:if>


    <c:if test="${not empty rates.getIfTextBook()}">
        <div class="row" id="creditDiv">
            <label class="col-sm-4">Textbook Used?</label>
            <div class="col-sm-8" id="ifCreditDiv">${rates.getIfTextBook()}</div>
        </div>
    </c:if>
    <c:if test="${not empty rates.tags}">
        <div class="row">
            <label class="col-sm-4">Tags Chosen</label>
            <div class="col-sm-8">${rates.tags}</div>
        </div>
    </c:if>

<c:if test="${not empty rates.spec}">
    <div class="row">
        <label class="col-sm-4">Specification</label>
        <div class="col-sm-8">${rates.spec}</div>
    </div>
</c:if>

    <c:if test="${rates.grade != 0}">
    <div class="row">
        <label class="col-sm-4">Grade Received</label>
        <div class="col-sm-8">${rates.grade}</div>
    </div>
    </c:if>
    <c:if test="${not empty rates.major}">
    <div class="row">
        <label class="col-sm-4">Major</label>
        <div class="col-sm-8">${rates.major}</div>
    </div>
    </c:if>

    <div class="row">
        <label class="col-sm-4">Rated By</label>
        <div class="col-sm-8">${rates.userID}</div>
    </div>
<hr>

</c:forEach>
    </div>
        <div class="container col-sm-2">
        </div>
        <div class="row book-list">
            ${textbookHtml}
        </div>
        </div>
</section>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>