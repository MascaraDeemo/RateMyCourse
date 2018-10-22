<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 22/10/18
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rate Course</title>
</head>
<body>
<form>
    Rate this Course:<br>
    <div class="sliderContainer1">
        <input type="range" min="1" max="10" value="5" class="slider" id="courseRate" onchange="changeRate()">
        <span id="rate_result">5</span>
    </div>
    <script>
        var result = document.getElementById("rate_result");
        var mine = document.getElementById("courseRate");
        function changeRate(){
            result.innerText = mine.value;
        }
    </script>
    <br>
    How difficult is this course?
    <div class="sliderContainer2">
        <input type="range" min="1" max="10" value="5" class="slider" id="difficulty" onchange="changeDiff()">
        <span id="diff_result">5</span>
    </div>
    <script>
        var diff = document.getElementById("diff_result");
        var span = document.getElementById("difficulty");
        function changeDiff(){
            diff.innerText = span.value;
        }
    </script>
    <br>
    Is this course taken for credit?<br>
    <input type="radio" name="credit" value="true">Yes
    <input type="radio" name="credit" value="false">No
    <br>
    Are you using textbook?<br>
    <input type="radio" name="textbook" value="true">Yes
    <input type="radio" name="textbook" value="false">No
    <br>

    <div class="form-element tagger">
        <div class="label">
            <div class="text">Select up to 3 Tags That Best Describe This Course </div>
        </div>
        <div class="tag-holder">
            <div class="scrollable">
                <a href="#" class="">Tough Grader</a>
                <a href="#" class="">Gives good feedback</a>
                <a href="#" class="">Respected</a>
                <a href="#" class="">Get ready to read</a>
                <a href="#" class="">Participation matters</a>
                <a href="#" class="">LOTS OF HOMEWORK</a>
                <a href="#" class="">Inspirational</a>
                <a href="#" class="">ACCESSIBLE OUTSIDE CLASS</a>
                <a href="#" class="">SO MANY PAPERS</a>
                <a href="#" class="">Clear grading criteria</a>
                <a href="#" class="">Hilarious</a>
                <a href="#" class="">TEST HEAVY</a>
                <a href="#" class="">GRADED BY FEW THINGS</a>
                <a href="#" class="">Amazing lectures</a>
                <a href="#" class="">Caring</a>
                <a href="#" class="">EXTRA CREDIT</a>
                <a href="#" class="">GROUP PROJECTS</a>
                <a href="#" class="">LECTURE HEAVY</a>
            </div>
    </div>
    </div>
    <input type="hidden" id="tags" name="tags" value="" />

    <div class="spec">
        <div>
            Add some more specification:
        </div>
        <textarea name="spec" id="spec" cols="30" rows="10"></textarea>
    </div>
    <div class="grade">
        <div class="text">Grade Received</div>
        <input name="grade" type="number">
    </div>
    <div class="major">
        <div class="text">What major are you?</div>
        <input name="major" type="text">
    </div>

    <div><button type="submit">Rate this Course</button> </div>

</form>

</body>
</html>
