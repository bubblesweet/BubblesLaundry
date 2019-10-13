<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.bubblesLaundry.dao.StoreDAO"%>
<%@ page import="com.bubblesLaundry.bean.StoreBean"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<meta http-equiv="Content-Type" charset="UTF-8">
<title>Set Appointment Time</title>
</head>
<body bgcolor="8cbcd0">
	<%
		StoreDAO dao = new StoreDAO();
	String Store_ID = dao.getStoreIdFromMachineId(Integer.parseInt(request.getParameter("machineId")));
	%><form method="POST" action='ReservationHandler' name="frmAddStore">
		<input type="hidden" name="action" value="insert" />
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-heading">Set Appointment Time</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Store ID</label> <input
									type="text" name="storeId" readonly="readonly"
									class="form-control" id="storeId"
									value="<%=Store_ID%>">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Machine ID</label> <input
									type="text" name="storeId" readonly="readonly"
									class="form-control" id="storeId"
									value="<%=request.getParameter("machineId")%>">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Location</label> <input type="text"
									class="form-control" name="s_location" readonly="readonly" id="s_location"
									value="<%=dao.getStoreByID(Store_ID).getS_location()%>">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Address</label> <input type="text"
									class="form-control" name="s_address" readonly="readonly" id="s_address"
									value="<%=dao.getStoreByID(Store_ID).getS_address()%>">
							</div>
						</div>
						<div class='col-md-6'>
							<div class="form-group">
								<label class="control-label">Appointment time</label>
								<div>Select Date: <input type="date" name="date" id="date">
									Select a Start time: <input type="time" name="start_time"
										id="start_time"> 
										Select a End time: <input type="time"
										name="end_time" id="end_time">
								</div>
							</div>
						</div>
					</div>
					<input type="submit" class="btn btn-primary" value="Confirm My Reservation"
					onclick="if (confirm('Are you sure you want to confirm reservation?')) { confirm('Reservation confirmed!') } else { return false; }">
				</div>
			</div>
		</div>
	</form>
</body>
</html>