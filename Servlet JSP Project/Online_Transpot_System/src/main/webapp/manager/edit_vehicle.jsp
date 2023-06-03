
<%@page import="com.transport.entites.Vehicle"%>
<%@page import="com.transport.conn.DbConnect"%>
<%@page import="com.transport.dao.VehicleDAO"%>
<%@page import="com.transport.entites.User"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Signup</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 13px 0 rgba(0, 0, 0, 0.3);
}

.error {
	color: red;
}
</style>
<%@include file="../component/css.jsp"%>
</head>
<body style="background: url('../img/tr4.png');">
	<%@include file="navbar.jsp"%>

	<%
	User user = (User) session.getAttribute("managerObj");
	int id = Integer.parseInt(request.getParameter("id"));
	VehicleDAO dao = new VehicleDAO(DbConnect.getConnection());
	Vehicle v = dao.getVehicleById(id);
	%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 ">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Update Truck</p>
						<c:if test="${not empty errorMsg}">
							<h5 class="text-center text-danger">${errorMsg}</h5>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form id="userRegister" novalidate class="row g-3"
							action="../updateVehicle" method="post">
							<input type="hidden" name="id" value="<%=v.getId()%>">
							<div class="col-6">
								<label class="form-label">Vehicle Number</label> <input
									type="text" name="vechicleNumber"
									value="<%=v.getVechicleNumber()%>"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Vechicle Type</label> <input
									type="text" name="vehicleType" value="<%=v.getVehicleType()%>"
									class="form-control form-control-sm">
							</div>
							<input type="hidden" name="location" value="<%=v.getLocation()%>">




							<div class="col-md-12">
								<label class="form-label">Availability</label> <select
									name="availability" class="form-control form-control-sm ">
									<option value="<%=v.getAvailability()%>"><%=v.getAvailability()%></option>
									<option>Booked</option>
									<option>Available</option>
								</select>
							</div>

							<div class="col-md-12">
								<label class="form-label">Insurance Status</label> <input
									value="<%=v.getInsuranceStatus()%>" id="pass" type="text"
									name="insuranceStatus" class="form-control form-control-sm">
							</div>

							<div class="col-md-12">
								<label class="form-label">Description</label> <input id="pass"
									value="<%=v.getDescription()%>" type="text" name="description"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Owner Name</label> <input id="pass"
									value="<%=v.getOwnerName()%>" type="text" name="ownerName"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Contact No</label> <input id="pass"
									value="<%=v.getContactNo()%>" type="text" name="contactNo"
									class="form-control form-control-sm">
							</div>

							<button class="btn bg-custom text-white col-md-12 mt-3">Update
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="js/user_script.js"></script>

</body>
</html>