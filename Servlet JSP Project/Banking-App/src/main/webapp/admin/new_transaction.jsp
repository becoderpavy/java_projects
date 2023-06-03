<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: New Transaction</title>
<%@include file="allcss.jsp"%>
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
				<h3 class="text-center">Transaction</h3>
				<c:if test="${not empty msg }">
					<h4 class="text-center text-success">${msg}</h4>
					<c:remove var="msg" scope="session" />
				</c:if>

				<c:if test="${not empty failedMsg }">
					<h4 class="text-center text-danger">${failedMsg}</h4>
					<c:remove var="failedMsg" scope="session" />
				</c:if>

				<div class="col-md-5 offset-md-4 mt-5">
					<form class="form-inline" action="../srchtrans" method="post">
						<div class="form-group mx-sm-3 mb-2">
							<input type="text" class="form-control" id="inputPassword2"
								placeholder="Enter Account No" name="accno">
						</div>
						<button type="submit" class="btn btn-primary mb-2">Search</button>
					</form>
				</div>
				<hr>

				<c:if test="${empty usobj}">

					<form action="" method="post">

						<div class="form-group row mt-3">
							<label for="colFormLabel"
								class="col-sm-2 offset-sm-1 col-form-label col-form-label">First
								Name</label>
							<div class="col-sm-3">
								<input type="email" class="form-control form-control"
									id="colFormLabel" value="" readonly="readonly">
							</div>

							<label for="colFormLabel"
								class="col-sm-2  col-form-label col-form-label">Last
								Name</label>
							<div class="col-sm-3">
								<input type="email" class="form-control form-control"
									id="colFormLabel" value="" readonly="readonly">
							</div>

						</div>


						<div class="form-group row mt-3">
							<label for="colFormLabel"
								class="col-sm-2 offset-sm-1 col-form-label col-form-label">Email</label>
							<div class="col-sm-3">
								<input type="email" class="form-control form-control"
									id="colFormLabel" value="" readonly="readonly">
							</div>

							<label for="colFormLabel"
								class="col-sm-2  col-form-label col-form-label">Phone No</label>
							<div class="col-sm-3">
								<input type="email" class="form-control form-control"
									id="colFormLabel" value="" readonly="readonly">
							</div>

						</div>


						<div class="form-group row mt-3">
							<label for="colFormLabel"
								class="col-sm-2 offset-sm-1 col-form-label col-form-label">Transaction
								Type</label>
							<div class="col-sm-3">
								<select class="form-control ">
									<option>--Select--</option>
									<option>Credit</option>
									<option>Debit</option>
								</select>
							</div>

							<label for="colFormLabel"
								class="col-sm-2 col-form-label col-form-label">Amount</label>
							<div class="col-sm-3">
								<input type="number" class="form-control form-control"
									id="colFormLabel">
							</div>
						</div>

						<div class="form-group row mt-3">
							<label for="colFormLabel"
								class="col-sm-2 offset-sm-1 col-form-label col-form-label">Total
								Amount</label>
							<div class="col-sm-3">
								<input type="email" class="form-control form-control"
									id="colFormLabel" value="" readonly="readonly">
							</div>
						</div>

						<div class="text-center">
							<button class="btn btn-success">Submit</button>
						</div>
					</form>

				</c:if>

				<c:if test="${not empty usobj}">

					<form action="../add_transaction" method="post">

						<div class="form-group row mt-3">
							<label for="colFormLabel"
								class="col-sm-2 offset-sm-1 col-form-label col-form-label">Account
								No</label>
							<div class="col-sm-3">
								<input name="accno" type="email"
									class="form-control form-control" id="colFormLabel"
									value="${ usobj.accountNo}" readonly="readonly">
							</div>

							<label for="colFormLabel"
								class="col-sm-2  col-form-label col-form-label">Full
								Name</label>
							<div class="col-sm-3">
								<input type="email" class="form-control form-control"
									id="colFormLabel" value="${ usobj.firstName} ${usobj.lastName}"
									readonly="readonly">
							</div>
						</div>


						<div class="form-group row mt-3">
							<label for="colFormLabel"
								class="col-sm-2 offset-sm-1 col-form-label col-form-label">Email</label>
							<div class="col-sm-3">
								<input type="email" class="form-control form-control"
									id="colFormLabel" value="${usobj.email }" readonly="readonly">
							</div>

							<label for="colFormLabel"
								class="col-sm-2  col-form-label col-form-label">Phone No</label>
							<div class="col-sm-3">
								<input type="email" class="form-control form-control"
									id="colFormLabel" value="${usobj.number }" readonly="readonly">
							</div>

						</div>


						<div class="form-group row mt-3">
							<label for="colFormLabel"
								class="col-sm-2 offset-sm-1 col-form-label col-form-label">Transaction
								Type</label>
							<div class="col-sm-3">
								<select class="form-control" name="transtype">
									<option value="select">--Select--</option>
									<option value="Credit">Credit</option>
									<option value="Debit">Debit</option>
								</select>
							</div>

							<label for="colFormLabel"
								class="col-sm-2 col-form-label col-form-label">Amount</label>
							<div class="col-sm-3">
								<input type="number" class="form-control form-control"
									name="amt" id="colFormLabel">
							</div>
						</div>

						<c:if test="${not empty balance}">
							<div class="form-group row mt-3">
								<label for="colFormLabel"
									class="col-sm-2 offset-sm-1 col-form-label col-form-label">Total
									Amount</label>
								<div class="col-sm-3">
									<input type="email" class="form-control form-control"
										id="colFormLabel" value="${balance}" readonly="readonly">
								</div>
							</div>
							<c:remove var="balance" scope="session" />
						</c:if>

						<div class="text-center">
							<button class="btn btn-success">Submit</button>
						</div>
					</form>
					<c:remove var="usobj" scope="session" />

				</c:if>
			</div>
		</div>
	</div>
</body>
</html>