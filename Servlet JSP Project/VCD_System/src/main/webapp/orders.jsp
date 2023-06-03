
<%@page import="com.entites.Movies"%>
<%@page import="com.entites.Orders"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.MoviesDAO"%>
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
<title>Artist | Order</title>
<%@include file="component/allCss.jsp"%>
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
							<th class="text-center">Quantity</th>
							<th class="text-center">Total Price</th>
							<th class="text-center">Payment Type</th>
						</tr>
					</thead>
					<tbody>

						<%
						User user = (User) session.getAttribute("userObj");
										OrdersDAO dao = new OrdersDAO(DBConnect.getConn());
										MoviesDAO dao2 = new MoviesDAO(DBConnect.getConn());
										List<Orders> list = dao.getOrdersByUser(user.getId());

										for (Orders o : list) {
											Movies m = dao2.getMoviesById(o.getMovieId());
						%>
						<tr>
							<th scope="row"><%=o.getOrderId()%></th>
							<td><%=user.getFullName()%><br><%=user.getAddress()%><br><%=user.getCity()%>
								,<%=user.getState()%>,<%=user.getPin()%><br>Mob No: <%=user.getMobNo()%>

							</td>
							<td><%=m.getMoviesName()%></td>
							<td class="text-center"><%=o.getQuantity()%></td>

							<td class="text-center">
								<%
								int tprice = Integer.parseInt(m.getCost()) * o.getQuantity();
								%> <%=m.getCost()%> * <%=o.getQuantity()%> = <%=tprice%>
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