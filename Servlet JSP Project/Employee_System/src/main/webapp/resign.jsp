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
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10">
				<div class="forgot">
					<h5 class="display-4 text-center ">Application for Resignation</h5>

					<c:if test="${not empty failedMsg}">
						<h5 class="text-center text-danger">${failedMsg}</h5>
						<c:remove var="failedMsg" scope="session" />
					</c:if>

					<c:if test="${not empty succMsg}">
						<h5 class="text-center text-success">${succMsg}</h5>
						<c:remove var="succMsg" scope="session" />
					</c:if>
				</div>

				<div class="card mt-5">

					<div class="card-body">
						<form class=" mt-4" action="add_resign" method="post">
							<div class="row">
								<div class="col">
									<label for="formGroupExampleInput">Sepration Type</label> <select
										name="rt" class="form-control selectpicker">
										<option value="">Select</option>
										<option value="On Roll Employee">On Roll Employee</option>
										<option value="Out Source">Out Source</option>
									</select>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col">
									<label for="formGroupExampleInput">Resignation Date</label> <input
										name="rd" type="date" class="form-control"
										placeholder="Select Date" aria-label="rsdate">
								</div>

								<div class="col">
									<label for="formGroupExampleInput">Last working Date </label> <input
										name="lw" type="date" class="form-control"
										placeholder="Select Date" aria-label="lsdate" />
								</div>
							</div>

							<br>
							<div class="row">
								<div class="col">
									<label for="formGroupExampleInput">Notice Surfed </label> <input
										name="ns" type="text" class="form-control" aria-label="notice">
								</div>
								<div class="col">
									<label for="formGroupExampleInput">Contact no </label> <input
										name="cn" type="number" class="form-control" aria-label="cont">
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-lg-12">
									<label for="formGroupExampleInput">Remarks </label> <input
										name="re" type="text" class="form-control" aria-label="adde">
								</div>
							</div>

							<input type="hidden" name="ui" value="${userobj.id}">

							<div class="card-footer">
								<button class="btn btn-info" type="submit">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>





































