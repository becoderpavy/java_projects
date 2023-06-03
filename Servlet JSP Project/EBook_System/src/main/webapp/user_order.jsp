<%@page import="com.entity.orderDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="com.DAO.OrderDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container mt-3 p-2">
		<!-- <div class="col-md-8 offset-md-2"> -->

			<table class="table table-bordered table-striped">
				<thead class="thead bg-primary">
					<tr>

						<th scope="col">Order Id</th>
						<th scope="col">Name</th>
						<th scope="col">Book Name</th>
						<th scope="col">Author</th>
						<th scope="col">Price</th>
						<th scope="col">Payment Type</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (user == null) {
						response.sendRedirect("login.jsp");
					} else {

						OrderDAOImpl dao = new OrderDAOImpl(ConnectionProvider.getConnection());
						String email = user.getEmail();
						List<orderDtls> order = dao.getOrder(email);

						for (orderDtls ord : order) {
					%>
					<tr>
						<td class="text-success text-center font-weight-bold"><%=ord.getOrderId()%></td>
						<td class="text-success text-center font-weight-bold"><%=ord.getUserName()%></td>
						<td class="text-success text-center font-weight-bold"><%=ord.getBookName()%></td>
						<td class="text-success text-center font-weight-bold"><%=ord.getBookAuthor()%></td>
						<td class="text-success text-center font-weight-bold"><%=ord.getPrice()%></td>
						<td class="text-success text-center font-weight-bold"><%=ord.getPaymentType().toUpperCase()%></td>
					</tr>
					<%
					}
					}
					%>

				</tbody>
			</table>
		<!-- </div> -->

	</div>
	<div style="margin-top: 170px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>