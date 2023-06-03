<%@page import="com.transport.entites.BookVehicle"%>
<%@page import="com.transport.entites.Vehicle"%>
<%@page import="java.util.List"%>
<%@page import="com.transport.conn.DbConnect"%>
<%@page import="com.transport.dao.VehicleDAO"%>
<%@page import="com.transport.entites.User"%>
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
					<p class="fs-4 text-center">Your Booking</p>

					<table class="table">
						<thead>
							<tr>
								<th scope="col">SL NO</th>
								<th scope="col">Username</th>
								<th scope="col">Vehicle Number</th>
								<th scope="col">Date</th>
								<th scope="col">KMs</th>
								<th scope="col">Amount</th>
								<th scope="col">Location</th>
							</tr>
						</thead>
						<tbody>
							<%
							int i = 0;
							User user = (User) session.getAttribute("managerObj");
							VehicleDAO dao = new VehicleDAO(DbConnect.getConnection());
							List<BookVehicle> list = dao.getBookingByLocation(user.getLocation());

							for (BookVehicle v : list) {
								i++;
							%>
							<tr>
								<td><%=i%></td>
								<td><%=v.getUserName()%></td>
								<td><%=v.getVehicleNumber()%></td>

								<td><%=v.getDate()%></td>
								<td><%=v.getKms()%></td>
								<td><%=v.getAmount()%></td>
								<td><%=v.getLocation()%></td>

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