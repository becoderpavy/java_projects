<%@page import="com.entity.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.admin.dao.CourseDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Teacher-Details</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">
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
				<i class="fas fa-bars m-3 fa-2x" onclick="toogleSidebar()"></i>
				<div class="container-fluid">
					<c:if test="${not empty succMsg}">
						<div class="alert alert-success" role="alert">${succMsg }</div>
						<c:remove var="succMsg" scope="session" />
					</c:if>
					<h3 class="text-center text-success">Add Information</h3>
					<hr>

					<div class="row p-5">
						<div class="col-md-4 offset-md-2">
							<div class="card bg-success" data-toggle="modal"
								data-target="#courceModal">
								<div class="card-body text-center text-white">
									<i class="fas fa-graduation-cap fa-2x"></i><br>
									<h3>Add Courses</h3>
								</div>
							</div>

							<!-- Staff Add Modal  -->
							<!-- Modal -->
							<div class="modal fade" id="courceModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Add
												Courses</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body bg-card-color">
											<div class="card">
												<div class="card-body">
													<form action="../add_course" method="post">
														<div class="from-group">
															<label>Enter Course Name</label> <input type="text"
																name="course" class="form-control" required="required">
														</div>
														<button class="btn btn-primary mt-2">Save</button>
													</form>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
							<!-- End Staff Modal -->
						</div>

						<!-- Start add Subject   -->
						<div class="col-md-4">
							<div class="card bg-danger" data-toggle="modal"
								data-target="#subModal">
								<div class="card-body text-center text-white">
									<i class="fas fa-book fa-2x"></i><br>
									<h3>Add Subject</h3>
								</div>
							</div>

							<!-- Staff Add Modal  -->

							<!-- Modal -->
							<div class="modal fade" id="subModal" tabindex="-1" role="dialog"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Add
												Subject</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body bg-card-color">

											<div class="card">
												<div class="card-body">
													<form action="../add_subject" method="post">



														<div class="form-group">
															<label for="">Courses</label> <select name="course"
																class="custom-select my-1 mr-sm-2"
																id="inlineFormCustomSelectPref">
																<option selected>Choose...</option>
																<%
																CourseDAO dao = new CourseDAO(DBConnect.getConn());
																List<Course> course = dao.getCourse();
																for (Course c : course) {
																%>
																<option value="<%=c.getCourse()%>"><%=c.getCourse()%></option>
																<%
																}
																%>
															</select>
														</div>
														<div class="form-group">
															<label for=""> Semestar</label> <select name="sem"
																class="custom-select my-1 mr-sm-2"
																id="inlineFormCustomSelectPref">
																<option selected>Choose...</option>
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
														<div class="form-group">
															<label for="">Enter Subject Name</label> <input
																required="required" type="text" name="subject" id=""
																class="form-control">
														</div>
														<button class="btn btn-primary">Submit</button>
													</form>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
							<!-- End Staff Modal -->
						</div>
						<!-- End add Subject   -->

						<!-- Start Add Teacher -->

						<div class="col-md-4 offset-md-2 mt-3">
							<div class="card bg-primary" data-toggle="modal"
								data-target="#teacherModal">
								<div class="card-body text-center text-white">
									<i class="fas fa-chalkboard-teacher fa-2x"></i><br>
									<h3>Add Teacher</h3>
								</div>
							</div>

							<!-- Staff Add Modal  -->
							<!-- Modal -->
							<div class="modal fade" id="teacherModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Add
												Teacher</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body bg-card-color">
											<div class="card">
												<div class="card-body">
													<form action="../add_teacher" method="post">
														<div class="form-group">
															<label for="">Enter Name</label> <input type="text"
																required name="name" id="" class="form-control">
														</div>

														<div class="form-group">
															<label for="">Gender</label> <select name="gender"
																required class="custom-select my-1 mr-sm-2"
																id="inlineFormCustomSelectPref">
																<option selected>Choose...</option>
																<option value="Male">Male</option>
																<option value="Female">Female</option>
															</select>
														</div>
														<div class="form-group">
															<label for="">Enter DOB</label> <input type="date"
																name="dob" id="" class="form-control" required>
														</div>
														<div class="form-group">
															<label for="">Enter Qualification</label> <input
																type="text" name="qua" id="" class="form-control"
																required>
														</div>

														<div class="form-group">
															<label for="">Enter Email</label> <input type="email"
																name="email" id="" class="form-control" required>
														</div>

														<div class="form-group">
															<label for="">Enter Password</label> <input type="text"
																name="password" id="" class="form-control" required>

														</div>
														<button class="btn btn-primary">Submit</button>
													</form>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
							<!-- End Staff Modal -->
						</div>

						<!-- End Add Teacher -->

						<!-- Start Add Student -->

						<div class="col-md-4 mt-3">
							<div class="card bg-warning" data-toggle="modal"
								data-target="#studentModal">
								<div class="card-body text-center text-white">
									<i class="fas fa-user-graduate fa-2x"></i><br>
									<h3>Add Student</h3>
								</div>
							</div>

							<!-- Student Add Modal  -->
							<!-- Modal -->
							<div class="modal fade" id="studentModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Add
												Student</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body bg-card-color">
											<div class="card">
												<div class="card-body">
													<form action="../add_student" method="post">

														<div class="form-group">
															<label for="">Enter Roll</label> <input type="text"
																name="roll" required id="" class="form-control">
														</div>

														<div class="form-group">
															<label for="">Enter Name</label> <input type="text"
																name="name" id="" class="form-control">
														</div>

														<div class="form-group">
															<label for="">Gender</label> <select name="gender"
																class="custom-select my-1 mr-sm-2"
																id="inlineFormCustomSelectPref">
																<option selected>Choose...</option>
																<option value="Male">Male</option>
																<option value="Female">Female</option>
															</select>
														</div>
														<div class="form-group">
															<label for="">Enter DOB</label> <input type="date"
																name="dob" required id="" class="form-control">
														</div>

														<div class="form-group">
															<label for="">Enter Address</label>
															<textarea name="address" required id="" cols="" rows="3"
																class="form-control"></textarea>
														</div>

														<div class="form-group">
															<label for="">Course</label> <select name="course"
																class="custom-select my-1 mr-sm-2"
																id="inlineFormCustomSelectPref">
																<option selected>Choose...</option>
																<%
																for (Course c : course) {
																%>
																<option value="<%=c.getCourse()%>"><%=c.getCourse()%></option>
																<%
																}
																%>
															</select>
														</div>


														<div class="form-group">
															<label for=""> Semestar</label> <select name="sem"
																class="custom-select my-1 mr-sm-2"
																id="inlineFormCustomSelectPref">
																<option selected>Choose...</option>
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

														<div class="form-group">
															<label for="">Enter Email</label> <input type="email"
																name="email" required id="" class="form-control">
														</div>

														<div class="form-group">
															<label for="">Enter Password</label> <input type="text"
																name="password" required id="" class="form-control">
														</div>
														<button class="btn btn-primary">Submit</button>
													</form>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
							<!-- End Student Modal -->
						</div>
						<!-- End Add Student -->
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>