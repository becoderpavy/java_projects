<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Notice-Details</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<c:if test="${empty tobj }">
		<c:redirect url="../tlogin.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>


			<div class="col-md-10">
				<i class="fas fa-bars m-3 fa-2x" onclick="toogleSidebar()"></i>
				<div class="container-fluid">
					<h3 class="text-center text-success">Notice</h3>
					<hr>
					<div class="col-md-6 offset-md-3">
						<form>
							<div class="form-group">
								<label>Enter Notice</label>
								<textarea rows="5" cols="" class="form-control"></textarea>
							</div>
							<button class="btn btn-success">Publish</button>
						</form>
					</div>

				</div>
			</div>

		</div>
	</div>
</body>
</html>