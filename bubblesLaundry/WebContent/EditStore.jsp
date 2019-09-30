<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bubblesLaundry.bean.StoreBean"%>
<%@ page import="com.bubblesLaundry.dao.StoreDAO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Store</title>
</head>
<body bgcolor="8cbcd0">
	<%
	StoreBean store = new StoreBean();
	%>
	<%
	StoreDAO dao = new StoreDAO();
	%>
	<form method="POST" action='StoreHandler' name="frmEditStore">
		<input type="hidden" name="action" value="edit" />
		<%
			String uid = request.getParameter("storeId");
			if (!((uid) == null)) {
				String storeId = uid;
				store = dao.getStoreByID(storeId);
		%>
		<table>
			<tr>
				<td>Store ID</td>
				<td><input type="text" name="storeId" readonly="readonly"
					value="<%=store.getS_id()%>"></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><input type="text" name="s_location"
					value="<%=store.getS_location()%>" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="s_address"
					value="<%=store.getS_address()%>" /></td>
			</tr>
			<tr>
				<td>Store Working Hours</td>
				<td><input type="time" name="start_time" id="start_time"><input
					type="time" name="end_time" id="end_time"></td>
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