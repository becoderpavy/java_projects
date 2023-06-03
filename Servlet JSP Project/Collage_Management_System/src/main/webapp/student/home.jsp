<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student: Home</title>
<%@include file="all_css.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<c:if test="${empty sobj }">
		<c:redirect url="../slogin.jsp" />
	</c:if>


	<%@include file="navbar.jsp"%>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10 ">

				<i class="fas fa-bars m-3 fa-2x" onclick="toogleSidebar()"></i>

				<h3 class="text-center text-primary">Welcome ${sobj.name }</h3>

				<c:if test="${not empty succMsg}">
					<div class="alert alert-success" role="alert">${succMsg }</div>
					<c:remove var="succMsg" scope="session" />
				</c:if>
				<hr>




			</div>


		</div>
	</div>
</body>
</html>