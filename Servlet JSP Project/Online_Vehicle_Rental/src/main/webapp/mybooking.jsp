<%@page import="com.entites.Vehicle"%>
<%@page import="com.dao.BookingDao"%>
<%@page import="com.entites.Booking"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.VehicleDao"%>
<%@page import="com.entites.User"%>
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
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="component/navbar.jsp"%>
	<div class="container-fluid p-4">
		<div class="col-md-12">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-4 text-center">Your Booking</p>


					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Booking Date</th>
								<th scope="col">Booking Id</th>
								<th scope="col">Vehicle</th>
								<th scope="col">Date</th>
								<th scope="col">No Of Days</th>
								<th scope="col">Total Price</th>
								<th scope="col">Status</th>

							</tr>
						</thead>
						<tbody>
							<%
							int i = 0;
							User user = (User) session.getAttribute("userObj");
							BookingDao dao = new BookingDao(DBConnect.getConnection());
							VehicleDao dao2 = new VehicleDao(DBConnect.getConnection());

							List<Booking> list = dao.getAllBookingByUser(user.getId());

							for (Booking b : list) {
								Vehicle v = dao2.getVehicleById(b.getVehicleId());
							%>
							<tr>
								<td><%=b.getBookingDate()%></td>
								<td><%=b.getOrderId()%></td>
								<td><%=v.getTitle()%> <br><%=v.getVehicleNumber()%></td>

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