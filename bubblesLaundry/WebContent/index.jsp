<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Bubbles Laundry</title>
</head>
<body bgcolor="8cbcd0">
<form method="POST" action='LoginValidation' name="frmLogin"><input
	type="hidden" name="action" value="login" />
<p><b>Welcome to Bubbles Laundry</b></p>
		<table>
			<tr>
				<td><h3>Please Login.</h3> <br>
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
				<td></td>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>