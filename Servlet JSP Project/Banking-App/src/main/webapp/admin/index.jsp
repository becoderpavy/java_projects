<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Home</title>
<%@include file="allcss.jsp"%>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<%@include file="main_navbar.jsp"%>


	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>

	<div class="container-fluid">
		<div class="row">
			<%@include file="left-navbar.jsp"%>
			<div class="col-md-10 offset-md-2">
				<div class="text-center">
					<hr>
					<img src="../img/b4.jpeg" style="width: 300px; height: 200px;">

					<h1>
						Hello Admin<br> Welcome to Banking Management System
					</h1>
					<hr>
				</div>
			</div>
		</div>
	</div>
</body>
</html>