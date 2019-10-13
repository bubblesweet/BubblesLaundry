<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.bubblesLaundry.bean.StoreBean"%>
<%@ page import="com.bubblesLaundry.dao.StoreDAO"%>
<%@ page import="com.bubblesLaundry.bean.MachineBean"%>
<%@ page import="com.bubblesLaundry.dao.MachineDAO"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>Store Details</title>
</head>
<body bgcolor="8cbcd0">

	<%
		StoreBean store = new StoreBean();
		StoreDAO dao = new StoreDAO();

		MachineDAO mdao = new MachineDAO();
		String Store_ID = request.getParameter("storeId");
		List<MachineBean> machineList = mdao.getMachinesByStoreID(Integer.parseInt(Store_ID));
		store = dao.getStoreByID(Store_ID);
	%>
	<h1>
		Store :
		<%=store.getS_location()%></h1>

	<h3>Available machines:</h3>
	<table border="1">
		<tr>
			<th>Machine Id</th>
			<th>Store Id</th>
			<th>Store Location</th>
			<th>Status</th>
		</tr>
		<tr>
			<%
				for (MachineBean machine : machineList) {
			%>
			<td><%=machine.getMachine_id()%></td>
			<td><%=machine.getStore_id()%></td>
			<td><%=machine.getStore_location()%></td>
			<td><%=machine.getMaintenance()%></td>
			<td><a
				href="StoreHandler?action=addReservation&machineId=<%=machine.getMachine_id()%>">
					Add Reservation to Cart</a></td>

		</tr>


		<%
			}
			//}
		%>
	</table>
	<p>
		<a href="MemberHandler?action=listStores">Go back to Store
			selection</a>
	</p>
</body>
</html>