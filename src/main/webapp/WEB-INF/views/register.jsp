<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<style type="text/css">
		.register-block{
			background: #DE6262;  /* fallback for old browsers */
			background: -webkit-linear-gradient(to bottom, #FFB88C, #DE6262);  /* Chrome 10-25, Safari 5.1-6 */
			background: linear-gradient(to bottom, #FFB88C, #DE6262); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
			float:left;
			width:100%;
			padding : 50px 0;
		}

		.btn-primary{color:#fff;background-color:#e16553;border-color:#e16553}
		.btn-primary:hover{color:#fff;background-color:#e16553;border-color:#e16553}
	</style>
</head>
<body>

<section class="register-block">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="card">
				<header class="card-header">
					<h4 class="card-title mt-2">Register</h4>
				</header>
				<article class="card-body">
	<form:form action="/register" method="post"  modelAttribute="user">
		<div class="form-group">
				<label>Username</label>
				<form:input cssClass="form-control" type="text" id="username" name="username" path="userName" required="required"/>
		</div>
		<div class="form-group">
				<label>Password</label>
				<form:input cssClass="form-control" type="password" id="password" name="password" path="password" required="required"/>
		</div>
		<div class="form-group">
				<label>Email</label>
				<form:input cssClass="form-control" type="email" id="Email" name="Email" path="userEmail" required="required"/>
		</div>
		<div class="form-group">
				<label>University</label>
				<form:input cssClass="form-control" type="text" id="University" name="University" path="university" required="required"/>
		</div>
		<div class="form-group">
			<button class="btn btn-primary btn-block" id="register" type="submit" value="Register">Register</button>
		</div>
		<small class="text-muted">By clicking the 'Sign Up' button, you confirm that you accept our Terms of use and Privacy Policy.</small>

	</form:form>
				</article>
				<div class="border-top card-body text-center">Have an account? <a href="/">Log In</a></div>
	</div>
		</div>
	</div>


</section>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>