
<%@page import="com.entites.Vehicle"%>
<%@page import="com.dao.VehicleDao"%>
<%@page import="com.entites.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.CategoryDao"%>
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
	<%@include file="../component/navbar.jsp"%>
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-9 ">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Edit Vehicle</p>
						<c:if test="${not empty errorMsg}">
							<h5 class="text-center text-danger">${errorMsg}</h5>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));

						VehicleDao dao = new VehicleDao(DBConnect.getConnection());
						CategoryDao dao2 = new CategoryDao(DBConnect.getConnection());

						Vehicle v = dao.getVehicleById(id);
						Category c = dao2.getCategoryById(v.getCategoryId());
						%>


						<form id="userRegister" novalidate class="row g-3"
							action="../updateVehicle" method="post"
							enctype="multipart/form-data">
							<div class="col-4">
								<label class="form-label">Vehicle Title</label> <input
									type="text" name="title" class="form-control form-control-sm"
									value="<%=v.getTitle()%>">
							</div>

							<div class="col-4">
								<label class="form-label">Vehicle Number</label> <input
									type="text" name="vehicleNumber"
									value="<%=v.getVehicleNumber()%>"
									class="form-control form-control-sm">
							</div>

							<div class="col-4">
								<label class="form-label">Category</label> <select
									name="categoryId" class="form-control form-control-sm ">
									<option value="<%=c.getId()%>"><%=c.getCategoryName()%></option>
									<%
									List<Category> list = dao2.getCategory();
									for (Category ca : list) {
									%>
									<option value="<%=ca.getId()%>"><%=ca.getCategoryName()%></option>
									<%
									}
									%>
								</select>
							</div>

							<div class="col-4">
								<label class="form-label">Availability</label> <select
									name="availability" class="form-control form-control-sm ">
									<option><%=v.getAvailability()%></option>
									<option>Booked</option>
									<option>Available</option>
								</select>
							</div>

							<div class="col-4">
								<label class="form-label">Price 1/Day</label> <input id="pass"
									type="number" name="perDay" value="<%=v.getPerDay()%>"
									class="form-control form-control-sm">
							</div>

							<div class="col-4">
								<label class="form-label">Insurance Status</label> <select
									name="insuranceStatus" class="form-control form-control-sm ">
									<option><%=v.getInsuranceStatus()%></option>
									<option>Active</option>
									<option>Inactive</option>
								</select>
							</div>

							<div class="col-md-12">
								<label class="form-label">Description</label> <input id="pass"
									type="text" name="description" value="<%=v.getDescription()%>"
									class="form-control form-control-sm">
							</div>

							<div class="col-4">
								<label class="form-label">Owner Name</label> <input id="pass"
									type="text" name="ownerName" value="<%=v.getOwnerName()%>"
									class="form-control form-control-sm">
							</div>

							<div class="col-4">
								<label class="form-label">Contact No</label> <input id="pass"
									type="text" name="contactNo" value="<%=v.getContactNo()%>"
									class="form-control form-control-sm">
							</div>

							<div class="col-4">
								<label class="form-label">image</label> <input id="pass"
									type="file" name="img" class="form-control form-control-sm">
							</div>

							<div class="col-4">
								<img alt="" src="../img/vehicle_img/<%=v.getImage()%>"
									width="100px" height="100px">
							</div>
							<input type="hidden" name="id" value="<%=v.getId()%>">
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