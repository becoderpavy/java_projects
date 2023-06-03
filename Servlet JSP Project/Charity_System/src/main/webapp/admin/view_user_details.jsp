<%@page import="com.entity.Organization"%>
<%@page import="com.dao.OrganizationDAOImpl"%>
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
<title>Admin: View User Details</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-1">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<%
						int id = Integer.parseInt(request.getParameter("pid"));

						PatientDAOImpl dao = new PatientDAOImpl(DBConnect.getConn());
						OrganizationDAOImpl dao2 = new OrganizationDAOImpl(DBConnect.getConn());
						Patient p = dao.getPatientById(id);
						%>
						<div class="row">
							<div class="col-md-4 ">
								<img src="../user_img/<%=p.getImage()%>" width="400"
									height="450">
							</div>
							<div class="col-md-6 offset-md-2">
								<h4 class="text-center">User Details</h4>

								<form action="add_user" method="post"
									enctype="multipart/form-data">
									<div class="form-row">
										<div class="form-group col-md-6">
											<label>Full Name</label> <input type="text" name="na"
												value="<%=p.getName()%>" readonly class="form-control">
										</div>

										<div class="form-group col-md-6">
											<label>Problem</label> <input type="text" name="pr"
												value="<%=p.getProblem()%>" readonly class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label>Address</label>
										<textarea rows="3" cols="" class="form-control" name="ad"
											readonly><%=p.getAddress()%></textarea>
									</div>
									<div class="form-row">
										<div class="form-group col-md-6">
											<%
											Organization o = dao2.getOrgById(p.getOid());
											%>
											<label>Organization Name</label> <input type="text" name="nm"
												value="<%=o.getOrgName()%>" readonly class="form-control">
										</div>
										<div class="form-group col-md-6">
											<label>Need Money</label> <input type="text" name="nm"
												value="<%=p.getNeedMoney()%>" readonly class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label>Document &nbsp &nbsp</label> <a
											href="../filedownload?fn=<%=p.getDocument()%>"
											class="btn btn-sm btn-primary"><i class="fas fa-download"></i>
											Download</a>
									</div>

									<%
									if ("Pending".equals(p.getStatus())) {
									%>
									<div class="row text-center">
										<a type="submit" class="btn btn-danger mr-2"
											href="../approve?ty=de&&id=<%=p.getId()%>"
											style="margin-left: 100px;"><i class="fas fa-trash"></i>
											Delete</a> <a href="../approve?ty=ap&&id=<%=p.getId()%>"
											type="submit" class="btn btn-success mr-2"><i
											class="fas fa-check-circle"></i> Approve</a> <a type="submit"
											href="../approve?ty=re&&id=<%=p.getId()%>"
											class="btn btn-danger"><i class="fas fa-times-circle"></i>
											Reject</a>

									</div>
									<%
									} else if ("Approved".equals(p.getStatus())) {
									%>
									<div class="text-center">
										<a class="btn btn-success text-white"><i
											class="fas fa-check-circle"></i> Approved</a>
									</div>
									<%
									} else {
									%>
									<div class="text-center">
										<a class="btn btn-danger text-white"><i
											class="fas fa-times-circle"></i> Rejected</a>
									</div>
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