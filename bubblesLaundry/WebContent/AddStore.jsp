<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.bubblesLaundry.dao.StoreDAO"%>
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
<title>Add Store Details</title>
</head>
<body>
	<%
		StoreDAO dao = new StoreDAO();
	%><form method="POST" action='StoreHandler' name="frmAddStore">
		<input type="hidden" name="action" value="insert" />

		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Store</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Store ID</label> <input
									type="text" name="storeId" readonly="readonly"
									class="form-control" id="storeId"
									value="<%=dao.getNewStoreID()%>">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Location</label> <input type="text"
									class="form-control" name="s_location" id="s_location">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Address</label> <input type="text"
									class="form-control" name="s_address" id="s_address">
							</div>
						</div>
						<div class='col-md-6'>
							<div class="form-group">
								<label class="control-label">Store Working Hours</label>
								<div>
									Select a Start time: <input type="time" name="start_time"
										id="start_time"> Select a End time: <input type="time"
										name="end_time" id="end_time">
								</div>
							</div>
						</div>
					</div>
					<input type="submit" class="btn btn-primary" value="Submit">
				</div>
			</div>
		</div>


	</form>
	<p>
		<a href="StoreHandler?action=listStores">View-All-Stores</a>
	</p>


</body>

</html>