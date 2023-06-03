<%@page import="com.entity.Professor"%>
<%@page import="com.entity.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.dao.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Add Professor</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<c:if test="${empty userobj }">
		<c:redirect url="index.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-1">
		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-md-6">
							<div class="card border-0">
								<div class="card-body">
									<!-- <div class="text-right">
										<a class="btn btn-danger text-white btn-sm"
											data-toggle="modal" data-target="#exampleModal">Edit</a>
									</div> -->

									<h4 class="text-center">Profile Details</h4>

									<c:if test="${not empty succMsg}">
										<h4 class="text-center text-success">${succMsg}</h4>
										<c:remove var="succMsg" />
									</c:if>

									<c:if test="${not empty errorMsg}">
										<h4 class="text-center text-danger">${errorMsg}</h4>
										<c:remove var="errorMsg" />
									</c:if>
									<form action="../addprofessor" method="post">
										<input type="hidden" name="id" value="${userobj.id}">
										<div class="form-group">
											<label> Name</label> <input type="text" name="na" readonly
												required class="form-control form-control-sm"
												value="${userobj.name }">
										</div>


										<div class="form-group">
											<label> Email</label> <input type="text" name="em" readonly
												required class="form-control form-control-sm"
												value="${userobj.email }">
										</div>

										<div class="form-group">
											<%
											Professor p = (Professor) session.getAttribute("userobj");
											DepartmentDAO dao2 = new DepartmentDAO(DbConnect.getConn());
											List<Department> list2 = dao2.getDepartment(p.getId());
											%>
											<label> Department</label>
											<%
											for (Department d : list2) {
											%>
											<input class="form-control" type="text" readonly="readonly" value="<%=d.getDeprtName()%>	">
											<%}%>
											
											
										</div>




									</form>
								</div>
							</div>
						</div>
						<div class="col-md-6 text-center p-5">
							<img alt="" src="img/prof.png" width="300px" height="300px">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- <!-- Button trigger modal -->

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<form action="updateprofessor" method="post">
						<input type="hidden" name="id" value="${userobj.id}">
						<div class="form-group">
							<label>Enter Name</label> <input type="text" name="na" required
								class="form-control form-control-sm" value="${userobj.name }">
						</div>

						<div class="form-group">
							<label>Department</label> <input type="text" name="de" required
								class="form-control form-control-sm"
								value="${userobj.department }">
						</div>

						<div class="form-group">
							<label>Course Name</label> <input type="text" name="cn" required
								class="form-control form-control-sm"
								value="${userobj.courseName }">
						</div>
						<div class="form-group">
							<label>Enter Email</label> <input type="text" name="em" required
								class="form-control form-control-sm" value="${userobj.email }">
						</div>

						<div class="form-group">
							<label>Enter Password</label> <input type="text" name="ps"
								required class="form-control form-control-sm">
						</div>
						<button class="btn btn-primary">Update</button>
					</form>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

				</div>
			</div>
		</div>
	</div> --%>


</body>
</html>