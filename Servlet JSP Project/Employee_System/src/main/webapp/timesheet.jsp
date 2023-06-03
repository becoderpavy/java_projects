<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<%@include file="common_nav/empnav.jsp"%>
<body style="background-color: #eceff1;">
	<div class="container padding-bottom-3x mb-2 mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10">
				<div class="forgot">
					<h3 class="display-4">Timesheet</h3>
					<c:if test="${not empty failedMsg}">
						<h5 class="text-center text-danger">${failedMsg}</h5>
						<c:remove var="failedMsg" scope="session" />
					</c:if>

					<c:if test="${not empty succMsg}">
						<h5 class="text-center text-success">${succMsg}</h5>
						<c:remove var="succMsg" scope="session" />
					</c:if>
				</div>
				<form class="card mt-4" action="add_attendance" method="post">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput">Account Name </label> <select
									name="an" class="form-control selectpicker" required>
									<option value="">--Select--</option>
									<option value="Non-Chargeable Jobs">Non-Chargeable
										Jobs</option>
									<option value="Treasury Pvt Ltd.">Treasury Pvt Ltd.</option>
									<option value="VFW Holding Limited">VFW Holding
										Limited</option>
								</select>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput">Date </label> <input
									name="da" type="date" class="form-control"
									placeholder="Select Date" aria-label="dateto" required>
							</div>
							<div class="col">
								<label for="formGroupExampleInput">Hours</label> <input
									name="ho" type="number" class="form-control" aria-label="hrs"
									required>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput">Milestone </label> <select
									name="mi" class="form-control selectpicker" required>
									<option value="">--Select--</option>
									<option value="Accounting FY 21- FY 22">Accounting FY
										21- FY 22</option>
								</select>
							</div>
							<div class="col">
								<label for="formGroupExampleInput">Remarks </label> <input
									name="re" type="text" class="form-control" aria-label="cont"
									required>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-lg-12">
								<label for="formGroupExampleInput">Narration </label> <input
									name="na" type="text" class="form-control" aria-label="adde"
									required>
							</div>
						</div>

						<input type="hidden" name="uid" value="${userobj.id}">

					</div>
					<div class="card-footer">
						<button class="btn btn-info" type="submit">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>





































