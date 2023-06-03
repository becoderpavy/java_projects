<%@page import="com.entity.Medicine"%>
<%@page import="com.dao.StoreDAO"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<%@page import="com.entity.Orders"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@page import="com.util.DBConnect"%>

<%@page import="com.dao.OrdersDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Artist | Order</title>
<%@include file="component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

.clink {
	text-decoration: none;
}
</style>
</head>
<body>
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="component/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-12 paint-card">
				<p class="fs-3 text-center">Your Orders</p>
				<table class="shadow-sm table table-bordered ">
					<thead class="table-dark">
						<tr>
							<th class="text-center">Order ID</th>
							<th>Delivery Address</th>
							<th>Product Details</th>
							<th>Quantity</th>
							<th class="text-center">Total Price</th>
							<th>Payment Type</th>
						</tr>
					</thead>
					<tbody>

						<%
						User user = (User) session.getAttribute("userObj");
						OrdersDAO dao = new OrdersDAO(DBConnect.getConnection());
						StoreDAO dao2 = new StoreDAO(DBConnect.getConnection());
						List<Orders> list = dao.getOrdersByUser(user.getId());

						for (Orders o : list) {
							Medicine p = dao2.getPaintById(o.getPaintId());
						%>
						<tr>
							<th scope="row"><%=o.getOrderId()%></th>
							<td><%=user.getFullName()%><br><%=user.getAddress()%><br><%=user.getCity()%>
								,<%=user.getState()%>,<%=user.getPin()%><br>Mob No: <%=user.getMobNo()%>

							</td>
							<td><%=p.getName()%></td>
							<td><%=o.getQuantity()%></td>

							<td>
								<%
								int tprice = Integer.parseInt(p.getPrice()) * o.getQuantity();
								%> <%=tprice%>
							</td>
							<td><%=o.getPaymentType()%></td>
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