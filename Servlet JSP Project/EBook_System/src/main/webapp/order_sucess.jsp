<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook: Order Success</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>

	<%
	if (user == null) {
		response.sendRedirect("login.jsp");
	} else {
	%>
	<div class="container text-center mt-3">
		<i class="fas fa-check-circle fa-5x text-success"></i>
		<h1>Thank You</h1>
		<h2>Your Order Successfully</h2>
		<h5>With in 7 Days Your Product will be Delivered In your Adress</h5>
		<a href="index.jsp" class="btn btn-primary mt-3">Home</a> <a
			href="user_order.jsp" class="btn btn-danger mt-3">View Order</a>
	</div>
	<%
	}
	%>

	<div style="margin-top: 85px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>