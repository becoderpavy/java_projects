<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave Portal</title>
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
					<h3 class="display-4 text-center">Leave Application</h3>
					<c:if test="${not empty failedMsg}">
						<h5 class="text-center text-danger">${failedMsg}</h5>
						<c:remove var="failedMsg" scope="session" />
					</c:if>

					<c:if test="${not empty succMsg}">
						<h5 class="text-center text-success">${succMsg}</h5>
						<c:remove var="succMsg" scope="session" />
					</c:if>

				</div>
				<form class="card mt-4" action="leave" method="post">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput">Leave Type</label> <select
									name="lt" class="form-control selectpicker" required>
									<option value="">Select</option>
									<option value="Privilege leaves">Privilege leaves</option>
									<option value="Skill Leaves">Skill Leaves</option>
									<option value="Covid-19">Covid-19</option>
								</select>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput">Date From</label> <input
									name="df" type="date" class="form-control"
									placeholder="Select Date" aria-label="dateto" required>
							</div>

							<div class="col">
								<label for="formGroupExampleInput">Date To</label> <input
									name="dt" type="date" class="form-control"
									placeholder="Select Date" aria-label="datefrm" required />
							</div>
						</div>



						<br>
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput">No Of Days </label> <input
									name="nd" type="number" class="form-control" aria-label="leave"
									required>
							</div>
							<div class="col">
								<label for="formGroupExampleInput">Contact no </label> <input
									name="cn" type="number" class="form-control" aria-label="cont"
									required>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-lg-12">
								<label for="formGroupExampleInput">Reasons </label> <input
									name="re" type="text" class="form-control" aria-label="adde"
									required />
							</div>
						</div>
					</div>
					<input type="hidden" name="uid" value="${userobj.id}">

					<div class="card-footer">
						<button class="btn btn-info" type="submit">Submit Leave
							Request</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>





































