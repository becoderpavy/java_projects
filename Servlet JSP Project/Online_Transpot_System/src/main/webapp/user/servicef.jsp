<%@page import="com.transport.entites.Vehicle"%>
<%@page import="java.util.List"%>
<%@page import="com.transport.entites.User"%>
<%@page import="com.transport.conn.DbConnect"%>
<%@page import="com.transport.dao.VehicleDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/css.jsp"%>
</head>
<body
	style="height: 110vh; background: linear-gradient(rgba(0, 0, 0, .5), rgba(0, 0, 0, .5)), url('../img/tr7.jpg'); background-repeat: no-repeat; background-size: cover;">
	<%@include file="navbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-5 offset-md-6 mt-5">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Book Your Truck</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<%
						String km = request.getParameter("km");
						int totalAmount = 1;
						if (km != null) {
							int kms = Integer.parseInt(km);
							totalAmount = 20 * kms;
						}

						User user = (User) session.getAttribute("userObj");
						%>
						<form action="../bookVh" method="post">
							<div class="row">
								<div class="col-md-6">
									<input required placeholder="Kilometers" name="kms" readonly
										type="text" class="form-control form-control-sm"
										value="<%=km%> Km">

								</div>

								<div class="col-md-6">
									<button class="btn btn-primary btn-sm disabled">Show
										Amount</button>
								</div>

							</div>

							<div class="mt-3">
								<input required placeholder="Amount" name="amount" readonly
									type="text" value="<%=totalAmount%>" class="form-control">
							</div>

							<div class="mt-3">
								<input required name="date" type="date" class="form-control">
							</div>


							<div class="col-md-12 mt-3">
								<select name="vehicleNumber"
									class="form-control form-control-sm ">
									<option value="">--Vehicle Number--</option>

									<%
									int i = 0;

									VehicleDAO dao = new VehicleDAO(DbConnect.getConnection());
									List<Vehicle> list = dao.getAllVehchicleByLocationAndAvaible(user.getLocation(), "Available");

									for (Vehicle v : list) {
										i++;
									%>
									<option><%=v.getVechicleNumber()%></option>
									<%
									}
									%>



								</select>
							</div>

							<input type="hidden" name="userName"
								value="<%=user.getUserName()%>"> 
								
								<input type="hidden"
								name="location" value="<%=user.getLocation()%>">
								
								

							<button type="submit"
								class="btn bg-custom text-white col-md-12 mt-3">Book</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>