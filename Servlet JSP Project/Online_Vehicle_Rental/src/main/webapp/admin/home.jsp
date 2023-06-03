<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.VehicleDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/css.jsp"%>
</head>
<body
	style="background: url('../img/carx2.jpeg'); background-repeat: no-repeat; background-size: cover;">
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../component/navbar.jsp"%>

	<%
	VehicleDao dao = new VehicleDao(DBConnect.getConnection());
	%>
	<div class="container p-3">
		<div class="row">
			<p class="text-center fs-3 text-white">Admin Dashboard</p>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-header text-center bg-primary text-white">
						<i class="fa-solid fa-list fa-2x"></i>
						<p class="fs-5">Category</p>

					</div>
					<div class="card-body text-center">
						<p class="fs-3"><%=dao.countCategory()%></p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-header text-center bg-primary text-white">
						<i class="fa-solid fa-car fa-2x"></i>
						<p class="fs-5">Vehicles</p>

					</div>
					<div class="card-body text-center">
						<p class="fs-3"><%=dao.countVehicle()%></p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-header text-center bg-primary text-white">
						<i class="fa-solid fa-clipboard fa-2x"></i>
						<p class="fs-5">Bookings</p>

					</div>
					<div class="card-body text-center">
						<p class="fs-3"><%=dao.countBooking()%></p>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>