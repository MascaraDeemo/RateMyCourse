<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rate My Course</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<spring:url value="/resources/core/css/signinRegister.css"
				var="signin" />
	<link href="${signin}" rel="stylesheet" />
</head>
<body>`

<section class = "login-block">
	<div class="container">
		<div class="row">
			<div class="col-md-4 login-sec">
				<h2 class="text-center">Login Now</h2>
						<form class="login-form" action="/login" method="post">
					<div class="form-group">
						<label for="Username" class="text-uppercase">Username</label>
						<input class="form-control" type="text" id="Username" name="Username"   required="required">
					</div>

					<div class="form-group">
						<label for="Password" class="text-uppercase">Password</label>
						<input class="form-control" type="password" id="Password" name="Password"  required="required">
					</div>
							<div class="form-check">
								<label class="form-check-label">
									<input type="checkbox" class="form-check-input">
									<small>Remember Me</small>
								</label>
					<button class="btn btn-login float-right" id="login" type="submit">Sign In</button>
							</div>
							<div class="copy-text">If you haven't got an account, please <a href="register">register</a> here.</div>
						</form>
			</div>
			<div class="col-md-8 banner-sec">
				<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="https://static.pexels.com/photos/33972/pexels-photo.jpg" alt="First slide">
							<div class="carousel-caption d-none d-md-block">
								<div class="banner-text">
									<h2>Rate My Course</h2>
									<p>Free to share opinions and experience </p>
								</div>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg" alt="First slide">
							<div class="carousel-caption d-none d-md-block">
								<div class="banner-text">
									<h2>Rate My Course</h2>
									<p> Search for the courses you are interested in</p>
								</div>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="https://images.pexels.com/photos/872957/pexels-photo-872957.jpeg" alt="First slide">
							<div class="carousel-caption d-none d-md-block">
								<div class="banner-text">
									<h2>Rate My Course</h2>
									<p> Highest Rated Courses! </p>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>
	</div>


<br><br><br>

</section>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>