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
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.table {
	font-size: 18px;
	text-align: left;
	text-decoration: none;
}
</style>
</head>
<body style="background-color: #f0f1f2;">

	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-1">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<%
						int pid = Integer.parseInt(request.getParameter("pid"));
						PatientDAOImpl dao = new PatientDAOImpl(DBConnect.getConn());
						Patient p = dao.getPatientById(pid);
						%>

						<div class="row">
							<div class="col-md-4 p-5">
								<img src="user_img/<%=p.getImage()%>" width="250" height="250">
							</div>
							<div class="col-md-6 offset-md-2">
								<h4 class="text-center">User Details</h4>

								<table class="table table-borderless">
									<tbody>
										<tr>
											<th scope="row">Name</th>
											<td><%=p.getName()%></td>

										</tr>
										<tr>
											<th scope="row">Problem</th>
											<td><%=p.getProblem()%></td>

										</tr>
										<tr>
											<th scope="row">Address</th>
											<td><%=p.getAddress()%></td>
										</tr>
										
										<tr>
											<th scope="row">Category</th>
											<td><%=p.getCategory()%></td>
										</tr>

										<tr>
											<th scope="row">Need Money</th>
											<td><%=p.getNeedMoney()%></td>
										</tr>

										<tr>
											<th scope="row">Raised Money</th>
											<td><%=p.getRaiseMoney()%></td>

										</tr>
									</tbody>
								</table>

								<c:if test="${empty donobj }">
									<div class="text-center">
										<a href="login.jsp" class="btn btn-danger text-white"><i
											class="fas fa-hand-holding-usd"></i> Donate</a>
									</div>
								</c:if>

								<c:if test="${not empty donobj }">
									<div class="text-center">
										<a href="donate.jsp?pid=<%=p.getId()%>"
											class="btn  btn-danger text-white ml-4"><i
											class="fas fa-hand-holding-usd"></i> Donate</a>
									</div>
								</c:if>


								<%-- 					<form action="../add_patient" method="post"
									enctype="multipart/form-data">
									<div class="form-row">

										<div class="form-group col-md-6">
											<label>Full Name</label> <input type="text" name="na"
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
									<c:if test="${empty donobj }">
										<div class="text-center">
											<a href="login.jsp" class="btn btn-danger text-white"><i
												class="fas fa-hand-holding-usd"></i> Donate</a>
										</div>
									</c:if>

									<c:if test="${not empty donobj }">
										<div class="text-center">
											<a href="donate.jsp" class="btn  btn-danger text-white ml-4"><i
												class="fas fa-hand-holding-usd"></i> Donate</a>
										</div>
									</c:if>

								</form> --%>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>