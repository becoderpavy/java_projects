
<%@page import="com.entites.Vehicle"%>
<%@page import="com.entites.User"%>
<%@page import="com.entites.Booking"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.BookingDao"%>
<%@page import="com.dao.UserDao"%>
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
	style="height: 90vh; background: linear-gradient(rgba(0, 0, 0, .2), rgba(0, 0, 0, .2)), url('../img/tr5.png'); background-repeat: no-repeat; background-size: cover;">
	<%@include file="../component/navbar.jsp"%>

	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<div class="container-fluid p-4">
		<div class="col-md-12">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-4 text-center">All Booking</p>

					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">SL NO</th>
								<th scope="col">Booking Date</th>
								<th scope="col">Booking Id</th>

								<th scope="col">Customer Details</th>
								<th scope="col">Vehicle Details</th>
								<th scope="col">From-TO Date</th>

								<th scope="col">NO Of Days</th>
								<th scope="col">Total Price</th>

								<th scope="col">Status</th>
							</tr>
						</thead>
						<tbody>
							<%
							int i = 0;

							VehicleDao dao = new VehicleDao(DBConnect.getConnection());
							UserDao dao2 = new UserDao(DBConnect.getConnection());
							BookingDao dao3 = new BookingDao(DBConnect.getConnection());

							List<Booking> list = dao3.getAllBooking();

							for (Booking b : list) {
								i++;
								User u = dao2.getUserById(b.getUserId());
								Vehicle v = dao.getVehicleById(b.getVehicleId());
							%>
							<tr>
								<td><%=i%></td>
								<td><%=b.getBookingDate()%></td>
								<td><%=b.getOrderId()%></td>

								<td><%=u.getName()%> <br> <%=u.getEmail()%><br> <%=u.getAddress()%>,<%=u.getCity()%><br>
									<%=u.getState()%>,<%=u.getPincode()%><br><%=u.getMobno() %></td>


								<td><%=v.getTitle()%><br> <%=v.getVehicleNumber()%></td>


								<td><%=b.getFromDate()%> - <%=b.getToDate()%></td>
								<td><%=b.getDay()%></td>
								<td><%=b.getTotalPrice()%></td>
								<td><%=b.getStatus()%></td>
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