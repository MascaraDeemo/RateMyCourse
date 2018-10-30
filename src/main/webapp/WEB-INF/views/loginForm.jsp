<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Log in</h3>
	<br>
	<form action="/login" method="post">
		<table>
			<tr>
				<td><label>Username</label></td>
				<td><input type="text" id="Username" name="Username"></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" id="Password" name="Password"></td>
			</tr>		
			<tr>
				<td><input id="login" type="submit" value="Log in"></td>
			</tr>

		</table>
	</form>
	if you haven't got an account, please register here:<a href="register">register</a>
</body>
</html>