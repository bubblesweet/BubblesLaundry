<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Error Page</title>
</head>
<body bgcolor="8cbcd0">
	<form method="post" action="LoginValidation">
		<table>
			<tr>
				<td><h3>Welcome Back. Please Login.</h3> <br>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Role:</td>
				<td><select name="role" size="1">
						<option value="member">Member</option>
						<option value="admin">Admin</option>
				</select></td>
			</tr>
			<tr>
				<td>Your Information is Incorrect</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>