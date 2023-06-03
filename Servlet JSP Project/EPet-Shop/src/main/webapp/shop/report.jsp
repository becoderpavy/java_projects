<%@page import="com.entity.OrderDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.OrderDAOImpl"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.ShopDAOImpl"%>
<%@page import="com.entity.ShopDtls"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop: Order Pet</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">


	<c:if test="${empty shopobj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container">
		<div class="card">
			<div class="card-body">
				<h3 class="text-center">All Order Report</h3>
				<button class="btn btn-primary btn-sm" onclick="window.print();">Print</button>
				<c:if test="${not empty failedMsg }">
					<h5 class="text-center text-danger">${failedMsg}</h5>
					<c:remove var="failedMsg" scope="session" />
				</c:if>

				<c:if test="${not empty succMsg }">
					<h5 class="text-center text-success">${succMsg}</h5>
					<c:remove var="succMsg" scope="session" />
				</c:if>

				<table class="table  mt-4 ">
					<thead>
						<tr>
							<th scope="col">Order Id</th>
							<th scope="col">Order Date</th>
							<th scope="col">User Details</th>
							<th scope="col">PetName</th>
							<th scope="col">Category</th>
							<th scope="col">Price</th>
							<th scope="col">Payment Type</th>
							<th scope="col">Status</th>

						</tr>
					</thead>
					<tbody>
						<%
						ShopDtls s = (ShopDtls) session.getAttribute("shopobj");
						int id = s.getId();
						OrderDAOImpl dao = new OrderDAOImpl(DBConnect.getConn());
						List<OrderDtls> list = dao.getOrderForShop(id);

						for (OrderDtls o : list) {
						%>
						<tr>
							<td><%=o.getOrderId()%></td>
							<td><%=o.getDate()%></td>
							<td><%=o.getUserName()%><br><%=o.getEmail()%><br><%=o.getPhno()%><br><%=o.getAddress()%></td>



							<td><%=o.getPetName()%></td>
							<td><%=o.getCategorie()%></td>
							<td><%=o.getPrice()%></td>
							<td><%=o.getPaymentType()%></td>
							<td><%=o.getStatus()%></td>

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