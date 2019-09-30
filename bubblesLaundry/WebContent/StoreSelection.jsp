<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.bubblesLaundry.bean.StoreBean"%>
<%@ page import="com.bubblesLaundry.dao.StoreDAO"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<title>All Stores</title>
</head>
<body bgcolor="8cbcd0">
	<%
		StoreDAO dao = new StoreDAO();
		List<StoreBean> storeList = dao.getAllStores();
	%>
		<table border="1">
		<tr>
			<th>Store Id</th>
			<th>Location</th>
			<th>Address</th>
			<th>Timings</th>
		</tr>
		<tr>
			<%
				/*while(itr.hasNext())
				 {
				 System.out.println(user.getId());*/
				for (StoreBean store : storeList) {
			%>
			<td><%=store.getS_id()%></td>
			<td><%=store.getS_location()%></td>
			<td><%=store.getS_address()%></td>
			<td><%=store.getS_timings()%></td>
			<td><a
				href="StoreHandler?action=editform&storeId=<%=store.getS_id()%>">Select</a></td>
		</tr>
		<%
			}
			//}
		%>
	</table>
</body>
</html>