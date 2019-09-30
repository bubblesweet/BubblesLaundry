<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bubblesLaundry.bean.MemberBean"%>
<%@ page import="com.bubblesLaundry.dao.AdminDAO"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Members</title>
</head>
<body bgcolor="8cbcd0">
	<%
		AdminDAO dao = new AdminDAO();
		List<MemberBean> memberList = dao.getAllMembers();
	%>
	<table border="1">
		<tr>
			<th>Member Id</th>
			<th>UserName</th>
			<th>Password</th>
		</tr>
		<tr>
			<%
				/*while(itr.hasNext())
				 {
				 System.out.println(user.getId());*/
				for (MemberBean member : memberList) {
			%>
			<td><%=member.getM_id()%></td>
			<td><%=member.getM_username()%></td>
			<td><%=member.getM_password()%></td>
			<td><a
				href="MemberHandler?action=editform&memberId=<%=member.getM_id()%>">Update</a></td>
			<td><a
				href="MemberHandler?action=delete&memberId=<%=member.getM_id()%>">Delete</a></td>

		</tr>
		<%
			}
			//}
		%>
	</table>
	<p>
		<a href="MemberHandler?action=insert">Add Member</a>
	</p>
</body>
</html>