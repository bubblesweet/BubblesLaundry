<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bubblesLaundry.dao.MachineDAO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Machine</title>
</head>
<body bgcolor="8cbcd0">
<%
	MachineDAO dao = new MachineDAO();
%>
<form method="POST" action='MachineHandler' name="frmAddMachine"><input
	type="hidden" name="action" value="insert" />
<p><b>Add New Machine</b></p>
<table>
	<tr>
		<td>Machine ID</td>
		<td><input type="text" name="machineId" readonly="readonly"
			value="<%=dao.getNewMachineID()%>"></td>
	</tr>
	<tr>
		<td>Store ID</td>
		<td><input type="text" name="store_id" /></td>
	</tr>
	<tr>
		<td>Maitenance?</td>
		<td><input type="text" name="maintenance" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Submit" /></td>
	</tr>
</table>
</form>
<p><a href="MachineHandler?action=listMachines">View-All-Machines</a></p>
</body>
</html>