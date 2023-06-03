<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp Login Page</title>
<link href="css/side.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<%@include file="common_nav/empnav.jsp"%>
<body style="background-color: #eceff1;">
	<div class="container">
		<br> <br> <br> <br>
		<div class="container">
			<div class="row">
				<div class="col-md-8 offset-md-2">
				<a href="tickt_status.jsp" class="btn btn-success mb-2">Status</a>
				<div class="card">
					<h3 class="text-center">Emplyoee Request</h3>
					
					<c:if test="${not empty failedMsg}">
						<h5 class="text-center text-danger">${failedMsg}</h5>
						<c:remove var="failedMsg" scope="session" />
					</c:if>

					<c:if test="${not empty succMsg}">
						<h5 class="text-center text-success">${succMsg}</h5>
						<c:remove var="succMsg" scope="session" />
					</c:if>
					
						<div class="card-body">
							<form action="add_helpline" method="post">
								<div class="form-group">
									<label>Enter Title</label> <input type="text" name="ti"
										class="form-control">
								</div>

								<div class="form-group">
									<label>Enter Reason</label>
									<textarea rows="6" cols="" class="form-control" name="re"></textarea>
								</div>
								<input name="uid" type="hidden" value="${userobj.id}">
								<button class="btn btn-primary">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>