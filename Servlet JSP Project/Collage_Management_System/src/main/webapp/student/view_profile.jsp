<%@page import="com.entity.Student"%>
<%@page import="com.admin.dao.StudentDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.admin.dao.CourseDAO"%>
<%@page import="com.entity.Course"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student : View Profile</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<c:if test="${empty sobj }">
		<c:redirect url="../slogin.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>


			<div class="col-md-10">
				<i class="fas fa-bars m-2 fa-2x" onclick="toogleSidebar()"></i>

				<div class="container-fluid">
					<div class="card">

						<div class="card-body bg-light">
							<div class="text-center">
								<i class="fas fa-user-circle fa-2x"></i>
								<p>Profile Details</p>
								<c:if test="${not empty succMsg}">
									<div class="alert alert-success" role="alert">${succMsg }</div>
									<c:remove var="succMsg" scope="session" />
								</c:if>
							</div>
							<form action="../update_student" method="post">
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for=""> Roll</label> <input type="text" name="roll"
											required id="" class="form-control" value="${sobj.roll }"
											readonly>
									</div>

									<div class="form-group col-md-4">
										<label for=""> Name</label> <input type="text" name="name"
											id="" class="form-control" value="${sobj.name }" readonly>
									</div>
									<div class="form-group col-md-4">
										<label for="">Gender</label> <input type="text" name="name"
											id="" class="form-control" value="${sobj.gender }" readonly>
									</div>


									<div class="form-group col-md-4">
										<label for=""> DOB</label> <input type="date" name="dob"
											required id="" class="form-control" value="${sobj.dob}"
											readonly>
									</div>

									<div class="form-group col-md-4">
										<label for="">Address</label>
										<textarea name="address" required id="" cols="" rows="2"
											readonly class="form-control">${sobj.address}</textarea>
									</div>


									<div class="form-group col-md-4">
										<label for="">Course</label>
										<textarea name="address" required id="" cols="" rows="2"
											readonly class="form-control">${sobj.course}</textarea>
									</div>


									<div class="form-group col-md-4">
										<label for="">Semestar</label> <input type="text" readonly
											value="${sobj.semestar }" name="email" required id=""
											class="form-control">
									</div>

									<div class="form-group col-md-4">
										<label for="">Email</label> <input type="email" readonly
											value="${sobj.email }" name="email" required id=""
											class="form-control">
									</div>

									<div class="form-group col-md-4">
										<label for="">Enter Password</label> <input type="text"
											readonly value="${sobj.password }" name="password" required
											id="" class="form-control">
									</div>
								</div>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>