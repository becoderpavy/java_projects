<%@page import="com.entites.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.Period"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entites.Vehicle"%>
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
<%@include file="component/css.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<div class="container p-3">
		<div class="row">
			<p class="fs-3 text-center">Booking Details</p>

			<%
			User u = (User) session.getAttribute("userObj");

			int id = Integer.parseInt(request.getParameter("id"));
			VehicleDao dao = new VehicleDao(DBConnect.getConnection());

			Vehicle v = dao.getVehicleById(id);

			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");

			Period p = Period.between(LocalDate.parse(fromDate), LocalDate.parse(toDate));
			int days = p.getDays();
			%>

			<div class="col-md-12 paint-card p-5">
				<div class="row">
					<div class="col-md-6 text-end">
						<img alt="" src="img/vehicle_img/<%=v.getImage()%>" width="330px"
							height="400px">
					</div>

					<div class="col-md-6">


						<form action="bookVehicle" method="post">
							<div class="row">
								<div class="col-md-6">
									<label>From Date</label> <input type="date" readonly
										class="form-control" name="fromDate" value="<%=fromDate%>">
								</div>

								<div class="col-md-6">
									<label>To Date</label> <input type="date" readonly
										class="form-control" name="toDate" value="<%=toDate%>">
								</div>
							</div>

							<div class="row mt-3">
								<div class="col-6">
									<label>Per Day</label> <input type="text" class="form-control"
										readonly value="<%=v.getPerDay()%>">
								</div>

								<div class="col-6">
									<label>No Of Day</label> <input type="text"
										class="form-control" readonly name="day" value="<%=days%>">
								</div>
							</div>

							<div class="mt-3">
								<label>Total Price</label> <input type="text"
									class="form-control" readonly name="totalPrice"
									value="<%=days * v.getPerDay()%>">
							</div>

							<div class="mt-3">
								<label>ID Card</label> <input type="text" class="form-control"
									name="idCard">
							</div>

							<input type="hidden" name="vehicleId" value="<%=v.getId()%>">
							<input type="hidden" name="userId" value="<%=u.getId()%>">


							<button class="btn btn-danger col-md-12 mt-4">Book</button>

						</form>

					</div>
				</div>
			</div>

		</div>
	</div>


</body>
</html>