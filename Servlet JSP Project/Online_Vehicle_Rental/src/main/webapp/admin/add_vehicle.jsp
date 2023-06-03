
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
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>

	<%@include file="../component/navbar.jsp"%>


	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 ">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Add Vehicle</p>
						<c:if test="${not empty errorMsg}">
							<h5 class="text-center text-danger">${errorMsg}</h5>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form id="userRegister" novalidate class="row g-3"
							action="../addVehicle" method="post"
							enctype="multipart/form-data">
							<div class="col-6">
								<label class="form-label">Vehicle Title</label> <input
									type="text" name="title" class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Vehicle Number</label> <input
									type="text" name="vehicleNumber"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Category</label> <select
									name="categoryId" class="form-control form-control-sm ">
									<option value="">--select--</option>
									<%
									CategoryDao dao = new CategoryDao(DBConnect.getConnection());
									List<Category> list = dao.getCategory();
									for (Category c : list) {
									%>
									<option value="<%=c.getId()%>"><%=c.getCategoryName()%></option>
									<%
									}
									%>
								</select>
							</div>

							<div class="col-6">
								<label class="form-label">Availability</label> <select
									name="availability" class="form-control form-control-sm ">
									<option value="">--select--</option>
									<option>Booked</option>
									<option>Available</option>
								</select>
							</div>

							<div class="col-6">
								<label class="form-label">Price 1/Day</label> <input id="pass"
									type="number" name="perDay"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Insurance Status</label> <select
									name="insuranceStatus" class="form-control form-control-sm ">
									<option value="">--select--</option>
									<option>Active</option>
									<option>Inactive</option>
								</select>
							</div>

							<div class="col-md-12">
								<label class="form-label">Description</label> <input id="pass"
									type="text" name="description"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Owner Name</label> <input id="pass"
									type="text" name="ownerName"
									class="form-control form-control-sm">
							</div>

							<div class="col-6">
								<label class="form-label">Contact No</label> <input id="pass"
									type="text" name="contactNo"
									class="form-control form-control-sm">
							</div>

							<div class="col-md-12">
								<label class="form-label">image</label> <input id="pass"
									type="file" name="img" class="form-control form-control-sm">
							</div>

							<button class="btn bg-custom text-white col-md-12 mt-3">Add
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