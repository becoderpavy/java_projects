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
<title>Admin : Edit Student</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<c:if test="${empty adobj }">
		<c:redirect url="../alogin.jsp" />
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

						<p class="card-header text-center">Edit Student Details</p>

						<%
						StudentDAO dao = new StudentDAO(DBConnect.getConn());
						Student s = dao.getStudentById(Integer.parseInt(request.getParameter("id")));
						%>

						<div class="card-body bg-light">
							<form action="../update_student" method="post">
								<input type="hidden" value="<%=s.getId()%>" name="id">
								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="">Enter Roll</label> <input type="text"
											name="roll" required id="" class="form-control"
											value="<%=s.getRoll()%>">
									</div>

									<div class="form-group col-md-4">
										<label for="">Enter Name</label> <input type="text"
											name="name" id="" class="form-control"
											value="<%=s.getName()%>">
									</div>

									<div class="form-group col-md-4">
										<label for="">Gender</label> <select name="gender"
											class="custom-select my-1 mr-sm-2"
											id="inlineFormCustomSelectPref">
											<%
											if ("Male".equals(s.getGender())) {
											%>
											<option value="Male">Male</option>
											<option value="Female">Female</option>
											<%
											} else {
											%>
											<option value="Female">Female</option>
											<option value="Male">Male</option>
											<%
											}
											%>

										</select>
									</div>
									<div class="form-group col-md-4">
										<label for="">Enter DOB</label> <input type="date" name="dob"
											required id="" class="form-control" value="<%=s.getDob()%>">
									</div>

									<div class="form-group col-md-4">
										<label for="">Enter Address</label>
										<textarea name="address" required id="" cols="" rows="2"
											class="form-control"><%=s.getAddress()%></textarea>
									</div>

									<div class="form-group col-md-4">
										<label for="">Course</label> <select name="course"
											class="custom-select my-1 mr-sm-2"
											id="inlineFormCustomSelectPref">

											<%
											CourseDAO d = new CourseDAO(DBConnect.getConn());
											List<Course> course = d.getCourse();
											for (Course c : course) {
											%>
											<option value="<%=c.getCourse()%>"><%=c.getCourse()%></option>
											<%
											}
											%>
										</select>
									</div>


									<div class="form-group col-md-4">
										<label for=""> Semestar</label> <select name="sem"
											class="custom-select my-1 mr-sm-2"
											id="inlineFormCustomSelectPref">
											<option value="<%=s.getSemestar()%>"><%=s.getSemestar()%>
											</option>
											<option value="1st Sem">1st Sem</option>
											<option value="2nd Sem">2nd Sem</option>
											<option value="3rd Sem">3rd Sem</option>
											<option value="4th Sem">4th Sem</option>
											<option value="5th Sem">5th Sem</option>
											<option value="6th Sem">6th Sem</option>
											<option value="7th Sem">7th Sem</option>
											<option value="8th Sem">8th Sem</option>
										</select>
									</div>

									<div class="form-group col-md-4">
										<label for="">Enter Email</label> <input type="email"
											value="<%=s.getEmail()%>" name="email" required id=""
											class="form-control">
									</div>

									<div class="form-group col-md-4">
										<label for="">Enter Password</label> <input type="text"
											value="<%=s.getPassword()%>" name="password" required id=""
											class="form-control">
									</div>
								</div>
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