<%@page import="com.entity.Teacher"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.admin.dao.TeacherDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin : Edit Teacher</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">
	<c:if test="${empty tobj }">
		<c:redirect url="../tlogin.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>


			<div class="col-md-10  p-5">

				<div class="card">
					<div class="card-body">
						<form action="../tupdate_teacher" method="post">
							<input type="hidden" value="${tobj.id}" name="id">
							<div class="form-row">

								<div class="form-group col-md-4">
									<label for="">Enter Name</label> <input type="text" required
										name="name" value="${tobj.name }" id="" class="form-control">
								</div>

								<div class="form-group col-md-4">
									<label for="">Gender</label> <select name="gender" required
										class="custom-select my-1 mr-sm-2"
										id="inlineFormCustomSelectPref">

										<c:if test="${tobj.gender eq 'Male' }">
											<option value="Male">Male</option>
											<option value="Female">Female</option>

										</c:if>

										<c:if test="${tobj.gender eq 'Female' }">
											<option value="Male">Male</option>
											<option value="Female">Female</option>

										</c:if>

									</select>
								</div>
								<div class="form-group col-md-4">
									<label for="">Enter DOB</label> <input type="date" name="dob"
										id="" value="${tobj.dob }" class="form-control" required>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-4">
									<label for="">Enter Qualification</label> <input type="text"
										name="qua" value="${tobj.qualification}" id=""
										class="form-control" required>
								</div>

								<div class="form-group col-md-4">
									<label for="">Enter Email</label> <input type="email"
										name="email" value="${tobj.email }" id="" class="form-control"
										required>
								</div>

								<div class="form-group col-md-4">
									<label for="">Enter Password</label> <input type="text"
										name="password" value="${tobj.password }" id=""
										class="form-control" required>

								</div>

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