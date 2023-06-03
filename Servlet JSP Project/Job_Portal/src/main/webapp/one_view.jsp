<%@page import="com.entity.User"%>
<%@page import="com.dao.CandidateDAO"%>
<%@page import="com.entity.Jobs"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.JobDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User : Signle Jobs</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">


				<%
				int id = Integer.parseInt(request.getParameter("id"));
				JobDAO dao = new JobDAO(DBConnect.getConn());
				Jobs j = dao.getJobsById(id);
				%>
				<div class="card mt-5">
					<h3 class="text-center">Job Details</h3>
					<c:if test="${not empty succMsg }">
						<h3 class=" text-center text-success">${ succMsg}</h3>
						<c:remove var="succMsg" />
					</c:if>
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6><%=j.getTitle()%></h6>
						<p><%=j.getDescription()%>.
						</p>
						<br>
						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Location: <%=j.getLocation()%>" readonly>
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Category: <%=j.getCategory()%>" readonly>
							</div>
						</div>
						<h6>
							Publish Date:
							<%=j.getPdate().toString()%></h6>
						<div class="text-center mt-5">


							<%
							User u = (User) session.getAttribute("userobj");
							CandidateDAO dao2 = new CandidateDAO(DBConnect.getConn());
							boolean f = dao2.checkJobApplyStatus(u.getId(), j.getId());

							if (f) {
							%>
							<button class="btn btn-success col-md-4" disabled>Applied</button>
							<%
							} else {
							
							%>
							<button data-toggle="modal" data-target="#jobModal"
								class="btn btn-success col-md-4">Apply</button>

							<%
							}
							%>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- Modal -->
	<div class="modal fade" id="jobModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Job Apply</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">


					<form action="applyJob" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label>Name</label> <input type="text" name="name"
								value="${userobj.name}" class="form-control">
						</div>

						<div class="form-group">
							<label>Email</label> <input type="email" name="email"
								value="${userobj.email }" class="form-control">
						</div>

						<input type="hidden" name="userId" value="${userobj.id }">
						<input type="hidden" name="jobId" value="<%=j.getId()%>">

						<div class="form-group">
							<label>Resume</label> <input type="file" name="file"
								class="form-control">
						</div>
						<div class="text-center mt-5">

							<button class="btn btn-success col-md-4">Apply</button>
						</div>
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

				</div>
			</div>
		</div>
	</div>


</body>
</html>