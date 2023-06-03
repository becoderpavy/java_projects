<%@page import="com.entity.Patient"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.PatientDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NGO : View One Patient</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.table {
	font-size: 18px;
	text-align: left;
	text-decoration: none;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty donobj}">
		<c:redirect url="login.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-1">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<%
						int pid = Integer.parseInt(request.getParameter("pid"));
						PatientDAOImpl dao = new PatientDAOImpl(DBConnect.getConn());
						Patient p = dao.getPatientById(pid);
						%>

						<div class="row">

							<div class="col-md-6 offset-md-2">
								<h4 class="text-center">Donate Details</h4>
								<c:if test="${not empty failedMsg }">
									<h5 class="text-center text-danger">${failedMsg}</h5>
									<c:remove var="failedMsg" scope="session" />
								</c:if>

								<c:if test="${not empty succMsg }">
									<h5 class="text-center text-success">${succMsg}</h5>
									<c:remove var="succMsg" scope="session" />
								</c:if>
								<div class="text-center">
									<img src="img/scan.jpg" width="250" height="250">
								</div>

								<form action="confirm.jsp" method="get">

									<input type="hidden" name="pid" class="form-control"
										value="<%=pid%>">

									<div class="form-group">
										<label>Enter Amount</label> <input type="number" name="amt"
											required class="form-control">
									</div>
									<div class="text-center">
										<button class="btn btn-primary">Payment</button>
									</div>

								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>