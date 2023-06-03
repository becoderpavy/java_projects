
<%@page import="com.dao.UserDAO"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.Paintings"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Orders"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.ArtistDAO"%>
<%@page import="com.dao.OrdersDAO"%>
<%@page import="com.entity.Artist"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Artist | Order</title>
<%@include file="../component/css.jsp"%>
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
	<c:if test="${ empty artObj }">
		<c:redirect url="../alogin.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<p class="fs-3 text-center">Manage Order</p>
				<table class="shadow-sm table table-bordered">
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
						Artist art = (Artist) session.getAttribute("artObj");
						OrdersDAO dao = new OrdersDAO(DBConnect.getConnection());
						ArtistDAO dao2 = new ArtistDAO(DBConnect.getConnection());
						UserDAO dao3 = new UserDAO(DBConnect.getConnection());

						List<Orders> list = dao.getOrdersByArtist(art.getId());

						for (Orders o : list) {
							Paintings p = dao2.getPaintById(o.getPaintId());
							User user = dao3.getUser(o.getUserId());
						%>
						<tr>
							<th scope="row" class="text-center"><%=o.getOrderId()%></th>
							<td><%=user.getFullName()%><br><%=user.getAddress()%><br><%=user.getCity()%>
								,<%=user.getState()%>,<%=user.getPin()%><br>Mob No: <%=user.getMobNo()%>

							</td>
							<td class="text-center"><%=p.getName()%></td>
							<td class="text-center"><%=o.getQuantity()%></td>

							<td class="text-center">
								<%
								int tprice = Integer.parseInt(p.getPrice()) * o.getQuantity();
								%> <%=o.getQuantity()%> * <%=p.getPrice()%> = <%=tprice%>
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