<%@page import="com.DAO.UserDAO"%>
<%@page import="com.entity.User"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
<%@include file="all_component/allcss.jsp"%>

</head>
<body style="background-color: #f7f7f7;">
	<%@include file="all_component/navbar.jsp"%>
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp" />
	</c:if>
	<div class="continer-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Edit Profile</h5>
						</div>
						<c:if test="${ not empty succMsg }">
							<h4 class="text-center text-success">${succMsg }</h4>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${ not empty failedMsg }">
							<h4 class="text-center text-danger">${failedMsg }</h4>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<%
						UserDAO dao = new UserDAO(DBConnect.getConn());
						int id = Integer.parseInt(request.getParameter("id"));
						User us = dao.getUserById(id);

						if (us != null) {
						%>
						<form action="EditServlet" method="post">
							<input type="hidden" value="<%=id%>" name="uid">
							<div class="form-group">
								<label>Full Name</label> <input type="text" required="required"
									class="form-control form-control-sm" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="name"
									value="<%=us.getFullName()%>">
							</div>
							<div class="form-group">
								<label>Email</label> <input type="email" required="required"
									class="form-control form-control-sm" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email"
									value="<%=us.getEmail()%>">
							</div>

							<div class="from-group">
								<label>Gender</label><br>

								<%
								if (us.getGender().equals("Male")) {
								%>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="gender" value="Male" checked>Male
									</label>
								</div>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="gender" value="Female">Female
									</label>
								</div>
								<%
								}
								%>

								<%
								if (us.getGender().equals("Female")) {
								%>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="gender" value="Male">Male
									</label>
								</div>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="gender" value="Female" checked>Female
									</label>
								</div>
								<%
								}
								%>


							</div>
							<br>
							<div class="form-group">
								<label>Collage Id</label> <input type="text" name="cid"
									required="required" class="form-control form-control-sm"
									id="exampleInputEmail1" aria-describedby="emailHelp" name="cid"
									value="<%=us.getCollageId()%>">
							</div>


							<div class="form-group">
								<label>User Category</label><br>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="category" value="Student">Student
									</label>
								</div>
								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="category" value="Faculity">Faculity
									</label>
								</div>

								<div class="form-check-inline">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="category" value="Others">Others
									</label>
								</div>
							</div>


							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Register</button>
						</form>
						<%
						}
						%>


					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 50px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>