<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bubblesLaundry.bean.MachineBean"%>
<%@ page import="com.bubblesLaundry.dao.MachineDAO"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Machines</title>
</head>
<body>
	<%
	MachineDAO dao = new MachineDAO();
		List<MachineBean> machineList = dao.getAllMachines();
	%>
	<table border="1">
		<tr>
			<th>Machine Id</th>
			<th>Store Id</th>
			<th>Maintenance?</th>
		</tr>
		<tr>
			<%
				/*while(itr.hasNext())
				 {
				 System.out.println(user.getId());*/
				for (MachineBean machine : machineList) {
			%>
			<td><%=machine.getMachine_id()%></td>
			<td><%=machine.getStore_id()%></td>
			<td><%=machine.getMaintenance()%></td>
			<td><a
				href="MachineHandler?action=editform&machineId=<%=machine.getMachine_id()%>">Update</a></td>
			<td><a
				href="MachineHandler?action=delete&machineId=<%=machine.getMachine_id()%>">Delete</a></td>

		</tr>
		<%
			}
			//}
		%>
	</table>
	<p>
		<a href="MachineHandler?action=insert">Add Machiner</a>
	</p>
</body>
</html>