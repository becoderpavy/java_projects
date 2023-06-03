<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	outline: none;
}

a:hover {
	text-decoration: none;
	outline: none;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userobj }">
		<c:redirect url="index.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container p-5 mt-5">
		<div class="row">
			<div class="col-md-4">
				<a href="view_dept.jsp?nm=IT">
					<div class="card">
						<div class="card-body text-center">
						<i class="fas fa-tv fa-3x"></i>
							<h3>IT Department</h3>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-4">
				<a href="view_dept.jsp?nm=Medical">
					<div class="card">
						<div class="card-body text-center">
						<i class="fas fa-hand-holding-medical fa-3x"></i>
							<h3>Medical Department</h3>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-4">
				<a href="view_dept.jsp?nm=Business administartion">
					<div class="card">
						<div class="card-body text-center">
						<i class="fas fa-business-time fa-3x"></i>
							<h3>Business Department</h3>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>


</body>
</html>