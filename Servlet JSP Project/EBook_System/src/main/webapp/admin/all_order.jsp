<%@page import="com.entity.orderDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.ConnectionProvider"%>
<%@page import="com.DAO.OrderDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.entity.userDtls"%>
<%
userDtls user1 = (userDtls) session.getAttribute("admin");
if (user1 == null) {
	response.sendRedirect("../login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Order Show</title>
<%@include file="allCss_file.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<h3 class="text-center mt-1">Hello, Admin</h3>

	<!-- <div class="container-fluid mt-3"> -->
		<table class="table table-bordered table-striped">
			<thead class="thead-dark bg-primary">
				<tr>

					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Address</th>
					<th scope="col">Phone No</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (user1 != null) {

					OrderDAOImpl dao = new OrderDAOImpl(ConnectionProvider.getConnection());

					List<orderDtls> order = dao.getAllOrder();

					for (orderDtls ord : order) {
				%>
				<tr>
					<td class=" text-danger text-center font-weight-bold"><%=ord.getOrderId()%></td>
					<td class=" text-danger font-weight-bold"><%=ord.getUserName()%></td>
					<td class="text-danger text-center font-weight-bold"><%=ord.getEmail()%></td>
					<td class="text-danger text-center font-weight-bold"><%=ord.getAddress()%></td>
					<td class="text-danger text-center font-weight-bold"><%=ord.getPhoneNo()%></td>
					<td class="text-danger text-center font-weight-bold"><%=ord.getBookName()%></td>
					<td class="text-danger text-center font-weight-bold"><%=ord.getBookAuthor()%></td>
					<td class="text-danger text-center font-weight-bold"><%=ord.getPrice()%></td>
					<td class="text-danger text-center font-weight-bold"><%=ord.getPaymentType().toUpperCase()%></td>
				</tr>
				<%
				}
				}
				%>

			</tbody>
		</table>

	<!-- </div> -->

	<div style="margin-top: 30px;">
		<%@include file="footer.jsp"%>
	</div>

</body>
</html>