<%@page import="com.entity.Orphans"%>
<%@page import="com.dao.OrphansDAO"%>
<%@page import="com.entity.Patient"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.PatientDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NGO : View One Patient</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty orphanObj}">
		<c:redirect url="../orphans_login.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-1">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<%
						int pid = Integer.parseInt(request.getParameter("pid"));
						int oid = Integer.parseInt(request.getParameter("oid"));
						OrphansDAO dao = new OrphansDAO(DBConnect.getConn());
						Orphans p = dao.getPatientByOrgAndId(pid, oid);
						%>

						<div class="row">
							<div class="col-md-4 p-3">
								<img src="../orphans_img/<%=p.getImage()%>" width="300"
									height="350">
							</div>
							<div class="col-md-6 offset-md-2">
								<h4 class="text-center">User Details</h4>

								<form action="../add_patient" method="post"
									enctype="multipart/form-data">
									<div class="form-row">

										<div class="form-group col-md-6">
											<label>Enter Name</label> <input type="text" name="na"
												required class="form-control" value="<%=p.getName()%>"
												readonly>
										</div>

										<div class="form-group col-md-6">
											<label>Problem</label> <input type="text" name="pr" required
												class="form-control" value="<%=p.getProblem()%>" readonly>
										</div>
									</div>

									<div class="form-group">
										<label>Address</label>
										<textarea required rows="3" cols="" class="form-control"
											readonly name="ad"><%=p.getAddress()%></textarea>
									</div>

									<div class="form-row">
										<div class="form-group col-md-6">
											<label>Need Money</label> <input required type="number"
												name="nm" class="form-control" value="<%=p.getNeedMoney()%>"
												readonly>
										</div>
										<div class="form-group col-md-6">
											<label>Raise Money</label> <input required type="text"
												name="doc" class="form-control"
												value="<%=p.getRaiseMoney()%>" readonly>
										</div>

									</div>
									<div class="form-group">
										<label>Category</label> <input required type="text" name="doc"
											class="form-control" value="<%=p.getCategory()%>" readonly>
									</div>
									<%
									if ("Approved".equals(p.getStatus())) {
									%>
									<a class="btn btn-success text-white btn-block  "><i
										class="fas fa-check-circle"></i> Approved</a>
									<%
									} else if ("Pending".equals(p.getStatus())) {
									%>
									<a class="btn btn-warning text-white btn-block"><i
										class="fas fa-clock"></i> Pending</a>
									<%
									} else {
									%>
									<a class="btn btn-danger btn-block"><i
										class="fas fa-times-circle"></i> Reject</a>
									<%
									}
									%>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>