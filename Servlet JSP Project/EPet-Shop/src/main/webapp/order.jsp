<%@page import="com.entity.OrderDtls"%>
<%@page import="com.entity.UserDtls"%>
<%@page import="com.DAO.OrderDAOImpl"%>

<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Pets</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-1">
		<div class="card">
			<div class="card-body">


				<h3 class="text-center text-primary">Your Order</h3>

				<table class="table table-striped mt-3">
					<thead class="bg-primary text-white">
						<tr>
							<th scope="col">Order Id</th>
							<th scope="col">Date</th>
							<th scope="col">Categories</th>
							<th scope="col">Pet Name</th>
							<th scope="col">Price</th>
							<th scope="col">Payment Type</th>
							<th scope="col">Status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						UserDtls u = (UserDtls) session.getAttribute("userobj");
						int uid = u.getId();
						OrderDAOImpl dao = new OrderDAOImpl(DBConnect.getConn());
						List<OrderDtls> list = dao.getOrderForUser(uid);
						for (OrderDtls o : list) {
						%><tr>
							<td><%=o.getOrderId()%></td>
							<td><%=o.getDate()%></td>
							<td><%=o.getCategorie()%></td>
							<td><%=o.getPetName()%></td>
							<td><%=o.getPrice()%></td>
							<td><%=o.getPaymentType()%></td>
							<td><%=o.getStatus()%></td>
							<td><a href="invoice.jsp?id=<%=o.getId()%>">Print</a></td>
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