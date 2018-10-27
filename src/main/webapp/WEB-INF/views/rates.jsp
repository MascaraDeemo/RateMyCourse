
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">


<body>

<h1>All Rates</h1>
<c:forEach var="rates" items="${rates}">
    <div class="row">
        <label class="col-sm-2">Rating</label>
        <div class="col-sm-10">${rates.rating}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Difficulty</label>
        <div class="col-sm-10">${rates.difficulty}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Taken for Credit?</label>
        <div class="col-sm-10">${rates.ifCredit}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Textbook used?</label>
        <div class="col-sm-10">${rates.textBook}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Tags chosen</label>
        <div class="col-sm-10">${rates.tags}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Specification</label>
        <div class="col-sm-10">${rates.spec}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Grade Received</label>
        <div class="col-sm-10">${rates.grade}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Major</label>
        <div class="col-sm-10">${rates.major}</div>
    </div>

</c:forEach>
</body>
</html>
