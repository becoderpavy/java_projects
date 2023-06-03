
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook: Order Success</title>
<%@include file="component/css.jsp"%>
</head>
<body>
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="component/navbar.jsp"%>


	<div class="container text-center mt-5 p-5">
		<i class="fas fa-check-circle fa-5x text-success"></i>
		<h1>Thank You</h1>
		<h2>Your Order Successfully</h2>
		<h5>With in 7 Days Your Product will be Delivered In your Address</h5>
		<a href="index.jsp" class="btn btn-primary mt-3">Home</a> <a
			href="orders.jsp" class="btn btn-danger mt-3">View Order</a>
	</div>


	<div style="margin-top: 85px;">
		<%@include file="component/footer.jsp"%>
	</div>
</body>
</html>