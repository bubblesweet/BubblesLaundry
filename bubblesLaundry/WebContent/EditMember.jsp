<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bubblesLaundry.bean.MemberBean"%>
<%@ page import="com.bubblesLaundry.dao.AdminDAO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Member</title>
</head>
<body>
	<%
		MemberBean member = new MemberBean();
	%>
	<%
		AdminDAO dao = new AdminDAO();
	%>
	<form method="POST" action='MemberHandler' name="frmEditUser">
		<input type="hidden" name="action" value="edit" />
		<%
			String uid = request.getParameter("memberId");
			if (!((uid) == null)) {
				String memberId = uid;
				member = dao.getMemberByID(memberId);
		%>
		<table>
			<tr>
				<td>Member ID</td>
				<td><input type="text" name="memberId" readonly="readonly"
					value="<%=member.getM_id()%>"></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="m_username"
					value="<%=member.getM_username()%>" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="m_password"
					value="<%=member.getM_password()%>" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
		<%
			} else
				out.println("ID Not Found");
		%>
	</form>
</body>
</html>