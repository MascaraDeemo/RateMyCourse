<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<h3>Register</h3>
	<br>
	<form:form action="/register" method="post"  modelAttribute="user">
		<table>
			<tr>
				<td><label>Username</label></td>
				<td><form:input type="text" id="username" name="username" path="userName" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><form:input type="password" id="password" name="password" path="password"/></td>
			</tr>		
			<tr>
				<td><label>Email</label></td>
				<td><form:input type="text" id="Email" name="Email" path="userEmail"/></td>
			</tr>	
			<tr>
				<td><label>University</label></td>
				<td><form:input type="text" id="University" name="University" path="university"/></td>
			</tr>	
			<tr>
				<td><input id="register" type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>