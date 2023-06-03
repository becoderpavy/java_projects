<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss_file.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<c:if test="${empty userobj }">
		<c:redirect url="../index.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						String nm = request.getParameter("nm");
						%>
						<h4 class="text-center">Add Department</h4>
						<c:if test="${not empty succMsg}">
							<h4 class="text-center text-success">${succMsg}</h4>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty errorMsg}">
							<h4 class="text-center text-danger">${errorMsg}</h4>
							<c:remove var="errorMsg" />
						</c:if>
						<form action="../adddepart" method="post">
							<input type="hidden" value="<%=id%>" name="id">
							<div class="form-group">
								<label>Professor name</label> <input type="text" name="nm"
									class="form-control" value="<%=nm%>" readonly>
							</div>
							<div class="form-group">
								<label>Department</label> <select name="de" required
									class="form-control form-control-sm">
									<option value="IT">IT</option>
									<option value="Business administartion">Business
										administartion</option>
									<option value="Medical">Medical</option>
								</select>
							</div>
							<button class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>