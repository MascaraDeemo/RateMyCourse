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
	<form action="login" method="post">
		<table>
			<tr>
				<td><label>username</label></td>
				<td><input type="text" id="Username" name="username"></td>
			</tr>
			<tr>
				<td><label>password</label></td>
				<td><input type="password" id="Password" name="password"></td>
			</tr>		
			<tr>
				<td><input id="submit" type="submit" value="Log in"></td>
			</tr>
		</table>
	</form>
</body>
</html>