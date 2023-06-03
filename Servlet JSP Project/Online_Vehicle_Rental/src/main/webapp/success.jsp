<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/css.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container text-center mt-5 p-5">
		<i class="fas fa-check-circle fa-5x text-success"></i>
		<h1>Thank You</h1>
		<h2>Your Booking Successfully</h2>
		<h5>Our Team Contact you very soon</h5>
		<a href="index.jsp" class="btn btn-primary mt-3">Home</a> <a
			href="mybooking.jsp" class="btn btn-danger mt-3">View Booking</a>
	</div>

</body>
</html>