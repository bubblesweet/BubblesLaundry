<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bubblesLaundry.dao.MemberDAO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Member</title>
</head>
<body>
<%
	MemberDAO dao = new MemberDAO();
%>
<form method="POST" action='MemberHandler' name="frmAddUser"><input
	type="hidden" name="action" value="insert" />
<p><b>Add New Member</b></p>
<table>
	<tr>
		<td>Member ID</td>
		<td><input type="text" name="memberId" readonly="readonly"
			value="<%=dao.getNewMemberID()%>"></td>
	</tr>
	<tr>
		<td>UserName</td>
		<td><input type="text" name="m_username" /></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="m_password" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Submit" /></td>
	</tr>
</table>
</form>
<p><a href="MemberHandler?action=listMembers">View-All-Members</a></p>
</body>
</html>