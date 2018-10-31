<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<<<<<<< HEAD
<html>

<body>


<form class="form-horizontal" action="courseRate" method="post" modelAttribute="rateForm">
    Rate this Course:<br>

    <div class="sliderContainer1">
        <input type="range"  min="1" max="10" value="5" class="slider" id="courseRate" name="rating" onchange="changeRate()">
        <span id="rate_result">5</span>
=======

<html>
<jsp:include page="fragments/header.jsp"/>
<body>

<section class="main_section">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header class="card-header">
                    <h4 class="card-title mt-2">Rate This Course</h4>
                </header>
                <article class="card-body">
<form class="form-horizontal" action="/rates/${courseId}" method="post" modelAttribute="rate">
    <div class="row">
        <label for="courseRate">How Would You Rate the Course?</label>
    </div>
    <div class="row">
        <input type="range"  min="1" max="10" value="5" class="form-control-range col-sm-10" id="courseRate" name="rating" onchange="changeRate()">
        <span class="col-sm-2" id="rate_result">  5</span>
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
    </div>
    <script>
        var result = document.getElementById("rate_result");
        var mine = document.getElementById("courseRate");
        function changeRate(){
            result.innerText = mine.value;
        }
    </script>
    <br>
<<<<<<< HEAD
    How difficult is this course?
    <div class="sliderContainer2">
        <input type="range" min="1" max="10" value="5" class="slider" id="difficulty" name="difficulty" onchange="changeDiff()">
        <span id="diff_result">5</span>
=======
    <div class="row">
        <label for="difficulty">How difficult is this course?</label>
    </div>
    <div class="row">
        <input type="range" min="1" max="10" value="5" class="form-control-range col-sm-10" id="difficulty" name="difficulty" onchange="changeDiff()">
        <span class="col-sm-2" id="diff_result">  5</span>
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
    </div>
    <script>
        var diff = document.getElementById("diff_result");
        var span = document.getElementById("difficulty");
        function changeDiff(){
            diff.innerText = span.value;
        }
    </script>
    <br>
<<<<<<< HEAD
    Is this course taken for credit?<br>
    <input type="radio" name="ifCredit" value="true">Yes
    <input type="radio" name="ifCredit" value="false">No
=======
    <div class="row">
        <label>Is this course taken for credit?</label>
    </div>
    <div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" id= "radio1" name="ifCredit" value="true">
        <label class="form-check-label" for="radio1">Yes</label>
    </div>
    <div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" id="radio2" name="ifCredit" value="false">
        <label class="form-check-label" for="radio2">No</label>
    </div>
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
    <br>
    <div class="row">
        <label>Are you using textbook?</label>
    </div>
    <div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="textbook" id="radio3" value="true">
        <label for="radio3">Yes</label>
    </div>
    <div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="textbook" id="radio4" value="false">
        <label for="radio4">No</label>
    </div>

    <br>

    <div class="form-element tagger">
        <div class="row">
            <label>Select up to 3 Tags That Best Describe This Course </label>
        </div>
        <div class="form-group">
            <select class="custom-select" name="tags" multiple="true" size="10">
                <option value="Tough Grader">Tough Grader</option>
                <option value="Gives good feedback">Gives good feedback</option>
                <option value="Get ready to read">Get ready to read</option>
                <option value="Participation matters">Participation matters</option>
                <option value="LOTS OF HOMEWORK">LOTS OF HOMEWORK</option>
                <option value="Clear grading criteria">Clear grading criteria</option>
                <option value="TEST HEAVY">TEST HEAVY</option>
                <option value="Amazing lectures">Amazing lectures</option>
                <option value="GROUP PROJECTS">GROUP PROJECTS</option>
                <option value="LECTURE HEAVY">LECTURE HEAVY</option>
            </select>
        </div>
<<<<<<< HEAD
        <div>
            <select name="tags" multiple="true" size="10">
                <option value="Tough Grader">Tough Grader</option>
                <option value="Gives good feedback">Gives good feedback</option>
                <option value="Get ready to read">Get ready to read</option>
                <option value="Participation matters">Participation matters</option>
                <option value="LOTS OF HOMEWORK">LOTS OF HOMEWORK</option>
                <option value="Clear grading criteria">Clear grading criteria</option>
                <option value="TEST HEAVY">TEST HEAVY</option>
                <option value="Amazing lectures">Amazing lectures</option>
                <option value="GROUP PROJECTS">GROUP PROJECTS</option>
                <option value="LECTURE HEAVY">LECTURE HEAVY</option>
            </select>
        </div>
=======
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
    </div>

    <br>


    <div class="row">
        <label>
            Add some more specification:
        </label>
    </div>
    <div class="form-group">
        <textarea class="form-control" name="spec" id="spec" cols="30" rows="5"></textarea>
    </div>
    <br>

    <div class="row">
    <label>Grade Received</label>
    </div>
    <div class="row form-group">
        <input class="form-control col-sm-2" name="grade" type="number">
        <span class="col-sm-1">%</span>
    </div>
<<<<<<< HEAD
    <div class="grade">
        <div class="text">Grade Received</div>
        <input name="grade" type="number">%
    </div>
    <div class="major">
        <div class="text">What major are you?</div>
        <select name="major">
=======
    <div class="row">
    <label>What major are you?</label>
    </div>
    <div class="form-group">
        <select class="form-control" name="major">
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
            <option value="Arts And Social Science">Arts And Social Science</option>
            <option value="Architecture,Design and Planning">Architecture,Design and Planning</option>
            <option value="Business">Business</option>
            <option value="Education and Social Work">Education and Social Work</option>
            <option value="Engineering and Information Technologies">Engineering and Information Technologies</option>
            <option value="Law">Law</option>
            <option value="Medicine and Health">Medicine and Health</option>
            <option value="Music">Music</option>
            <option value="Science,Agriculture,Environment and Veterinary Science">Science,Agriculture,Environment and Veterinary Science</option>
        </select>
    </div>

    <div class="form-group">
        <button class="btn btn-primary btn-block" type="submit" value="Rate This Course">Rate this Course</button>
    </div>

                    </form>
                </article>
            </div>
        </div>
    </div>
</section>

<jsp:include page="fragments/footer.jsp"/>
</body>

</html>