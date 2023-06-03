<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Open Account</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="main_navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="left-navbar.jsp"%>
			<div class="col-md-6 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Open New Account</h3>
						<c:if test="${not empty SucessMsg}">
							<h5 class="text-center text-success">Account Open
								Successfully..</h5>
							<c:remove var="SucessMsg" />
						</c:if>

						<c:if test="${not empty ErrorMsg}">
							<h5 class="text-center text-success">..</h5>
							<c:remove var="ErrorMsg" />
						</c:if>

						<form action="../create_accnt" method="post">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">First Name</label> <input name="fn"
										type="text" class="form-control form-control-sm"
										id="inputEmail4" placeholder="First Name">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Last Name</label> <input name="ln"
										type="text" class="form-control form-control-sm"
										id="inputPassword4" placeholder="Last Name">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Email</label> <input name="em"
										type="email" class="form-control form-control-sm"
										id="inputEmail4" placeholder="Email">
								</div>
								<div class="form-group col-md-6">
									<label for="Phonenumber">Phone Number</label> <input
										type="number" class="form-control form-control-sm" name="ph">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">DOB</label> <input name="dob"
										type="date" class="form-control form-control-sm"
										id="inputEmail4" placeholder="dd-mm-yyyy">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Adhar Number</label> <input
										name="adh" type="number" class="form-control form-control-sm"
										id="inputPassword4" placeholder="" value="0000-0000-0000-0000">
								</div>
							</div>


							<div class="form-group">
								<label for="inputAddress">Address</label> <input name="add"
									type="text" class="form-control form-control-sm"
									id="inputAddress" placeholder="1234 Main St">
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputCity">City</label> <input name="city"
										type="text" class="form-control form-control-sm"
										id="inputCity">
								</div>
								<div class="form-group col-md-4">
									<label for="inputCity">State</label> <input name="st"
										type="text" class="form-control form-control-sm"
										id="inputState">
								</div>
								<div class="form-group col-md-2">
									<label for="inputZip">Zip</label> <input type="number"
										class="form-control form-control-sm" name="zip">
								</div>
							</div>
							<div class="form-group">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="gridCheck"
										name="check"> <label class="form-check-label"
										for="gridCheck"> Agree Terms & Condition </label>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Sign in</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>