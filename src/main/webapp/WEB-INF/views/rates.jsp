<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragments/header.jsp"/>
<body>


<h1>All Rates</h1>
<div class="row">
    ${textbookHtml}
</div>
<label>Course Description</label>
<div>${descrip}</div>
<hr>
<c:forEach var="rates" items="${rates}">
    <div class="row">


        <label class="col-sm-2">Rating</label>
        <div class="col-sm-10">${rates.rating}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Difficulty</label>
        <div class="col-sm-10">${rates.difficulty}</div>
    </div>




<c:if test="${not empty rates.isIfCredit()}">
    <div class="row" id="creditDiv">
        <label class="col-sm-2">Take For Credit?</label>
        <div class="col-sm-10">${rates.isIfCredit()}</div>
    </div>
</c:if>


    <c:if test="${not empty rates.getIfTextBook()}">
        <div class="row" id="creditDiv">
            <label class="col-sm-2">Textbook Used?</label>
            <div class="col-sm-10" id="ifCreditDiv">${rates.getIfTextBook()}</div>
        </div>
    </c:if>
    <c:if test="${not empty rates.tags}">
        <div class="row">
            <label class="col-sm-2">Tags Chosen</label>
            <div class="col-sm-10">${rates.tags}</div>
        </div>
    </c:if>

<c:if test="${not empty rates.spec}">
    <div class="row">
        <label class="col-sm-2">Specification</label>
        <div class="col-sm-10">${rates.spec}</div>
    </div>
</c:if>

    <c:if test="${rates.grade != 0}">
    <div class="row">
        <label class="col-sm-2">Grade Received</label>
        <div class="col-sm-10">${rates.grade}</div>
    </div>
    </c:if>
    <c:if test="${not empty rates.major}">
    <div class="row">
        <label class="col-sm-2">Major</label>
        <div class="col-sm-10">${rates.major}</div>
    </div>
    </c:if>

    <div class="row">
        <label class="col-sm-2">Rated By</label>
        <div class="col-sm-2">${rates.userID}</div>
    </div>
<hr>

</c:forEach>
</body>

<jsp:include page="fragments/footer.jsp"/>
</html>