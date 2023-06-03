<%@page import="com.transport.entites.Vehicle"%>
<%@page import="java.util.List"%>
<%@page import="com.transport.entites.User"%>
<%@page import="com.transport.conn.DbConnect"%>
<%@page import="com.transport.dao.VehicleDAO"%>
<%@page import="com.transport.dao.UserDAO"%>
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
	style="height: 90vh; background: linear-gradient(rgba(0, 0, 0, .2), rgba(0, 0, 0, .2)), url('../img/tr5.png'); background-repeat: no-repeat; background-size: cover;">
	<%@include file="navbar.jsp"%>


	<div class="container-fluid p-4">
		<div class="col-md-12">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-4 text-center">Truck Details</p>

					<c:if test="${not empty errorMsg}">
						<p class="fs-4 text-center text-danger">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<c:if test="${not empty succMsg}">
						<p class=" fs-4 text-center text-success">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<table class="table">
						<thead>
							<tr>
								<th scope="col">SL No</th>
								<th scope="col">Vehicle Number</th>
								<th scope="col">Vechicle Type</th>
								<th scope="col">Location</th>
								<th scope="col">Availability</th>
								<th scope="col">Insurance Status</th>
								<th scope="col">Description</th>
								<th scope="col">Owner Name</th>
								<th scope="col">Contact No</th>
								<th scope="col">Action</th>


							</tr>
						</thead>
						<tbody>
							<%
							int i = 0;
							User user = (User) session.getAttribute("managerObj");
							VehicleDAO dao = new VehicleDAO(DbConnect.getConnection());
							List<Vehicle> list = dao.getAllVehchicleByLocation(user.getLocation());

							for (Vehicle v : list) {
								i++;
							%>
							<tr>
								<td><%=i%></td>
								<td><%=v.getVechicleNumber()%></td>
								<td><%=v.getVehicleType()%></td>
								<td><%=v.getLocation()%></td>
								<td><%=v.getAvailability()%></td>
								<td><%=v.getInsuranceStatus()%></td>
								<td><%=v.getDescription()%></td>
								<td><%=v.getOwnerName()%></td>
								<td><%=v.getContactNo()%></td>
								<td><a href="edit_vehicle.jsp?id=<%=v.getId()%>"
									class="btn btn-sm btn-primary">Edit</a> <a
									href="../deleteVehicle?id=<%=v.getId()%>"
									class="btn btn-sm btn-danger ms-1">Delete</a></td>
							</tr>
							<%
							}
							%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>