<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<body>


<form class="form-horizontal" action="/rates/${courseId}" method="post" modelAttribute="rate">
    Rate this Course:<br>

    <div class="sliderContainer1">
        <input type="range"  min="1" max="10" value="5" class="slider" id="courseRate" name="rating" onchange="changeRate()">
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
        <input type="range" min="1" max="10" value="5" class="slider" id="difficulty" name="difficulty" onchange="changeDiff()">
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
    <input type="radio" name="ifCredit" value="true">Yes
    <input type="radio" name="ifCredit" value="false">No
    <br>
    Are you using textbook?<br>
    <input type="radio" name="textbook" value="true">Yes
    <input type="radio" name="textbook" value="false">No
    <br>

    <div class="form-element tagger">
        <div class="label">
            <div class="text">Select up to 3 Tags That Best Describe This Course </div>
        </div>
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
    </div>

    <div class="specification">
        <div>
            Add some more specification:
        </div>
        <textarea name="spec" id="spec" cols="30" rows="10"></textarea>
    </div>
    <div class="grade">
        <div class="text">Grade Received</div>
        <input name="grade" type="number">%
    </div>
    <div class="major">
        <div class="text">What major are you?</div>
        <select name="major">
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

    <div><button type="submit">Rate this Course</button> </div>

</form>

</body>
</html>