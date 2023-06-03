

<%@page import="com.entites.User"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="com.entites.Movies"%>
<%@page import="com.entites.Orders"%>
<%@page import="java.util.List"%>

<%@page import="com.dao.MoviesDAO"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.OrdersDAO"%>
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
<title>Admin | Order</title>
<%@include file="../component/allCss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

.clink {
	text-decoration: none;
}
</style>
</head>
<body class="bg-light">
	<c:if test="${ empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../component/admin_navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<p class="fs-3 text-center">Manage Order</p>
				<table class="shadow-sm table table-bordered table-striped">
					<thead class="table-dark">
						<tr>
							<th class="text-center">Order ID</th>
							<th>Delivery Address</th>
							<th class="text-center">Order Details</th>
							<th class="text-center">Quantity</th>
							<th class="text-center">Total Price</th>
							<!-- <th>Status</th>
							<th>Action</th> -->
							<th class="text-center">Payment Type</th>
						</tr>
					</thead>
					<tbody>

						<%
						OrdersDAO dao = new OrdersDAO(DBConnect.getConn());
						MoviesDAO dao2 = new MoviesDAO(DBConnect.getConn());
						UserDAO dao3 = new UserDAO(DBConnect.getConn());

						List<Orders> list = dao.getAllOrders();

						for (Orders o : list) {
							Movies m = dao2.getMoviesById(o.getMovieId());
							User user = dao3.getUser(o.getUserId());
						%>
						<tr>
							<th scope="row" class="text-center"><%=o.getOrderId()%></th>
							<td><%=user.getFullName()%><br><%=user.getAddress()%><br><%=user.getCity()%>
								,<%=user.getState()%>,<%=user.getPin()%><br>Mob No: <%=user.getMobNo()%>

							</td>
							<td class="text-center"><%=m.getMoviesName()%></td>
							<td class="text-center"><%=o.getQuantity()%></td>

							<td class="text-center">
								<%
								int tprice = Integer.parseInt(m.getCost()) * o.getQuantity();
								%> <%=o.getQuantity()%> * <%=m.getCost()%> = <%=tprice%>
							</td>
							<td class="text-center"><%=o.getPaymentType()%></td>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>