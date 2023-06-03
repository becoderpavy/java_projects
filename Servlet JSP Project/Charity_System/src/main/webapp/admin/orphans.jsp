<%@page import="com.entity.Orphanage"%>
<%@page import="com.entity.Orphans"%>
<%@page import="com.dao.OrphanageDAO"%>
<%@page import="com.dao.OrphansDAO"%>
<%@page import="com.entity.Organization"%>
<%@page import="com.dao.OrganizationDAOImpl"%>
<%@page import="com.entity.Patient"%>
<%@page import="java.util.List"%>
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
<title>Help Seeker</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adobj}">
		<c:redirect url="../login.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="card">
			<div class="card-body">
				<h4 class="text-center">All Orphans</h4>
				<c:if test="${not empty succMsg }">
					<h5 class="text-center text-success">${succMsg }</h5>
					<c:remove var="succMsg" scope="session" />
				</c:if>

				<c:if test="${not empty failedMsg }">
					<h5 class="text-center text-danger">${failedMsg }</h5>
					<c:remove var="failedMsg" scope="session" />
				</c:if>
				<table class="table mt-2">
					<thead class="bg-success text-white">
						<tr>
							<th scope="col">Image</th>
							<th scope="col">Name</th>
							<th scope="col">Problem</th>
							<th scope="col">Organization Name</th>
							<th scope="col">Status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						OrphansDAO dao = new OrphansDAO(DBConnect.getConn());
						OrphanageDAO dao2 = new OrphanageDAO(DBConnect.getConn());
						List<Orphans> list = dao.getAllPatient();
						for (Orphans p : list) {
						%>
						<tr>
							<td><img alt="" src="../orphans_img/<%=p.getImage()%>"
								style="width: 50px; height: 50px;"></td>
							<td><%=p.getName()%></td>
							<td><%=p.getProblem()%></td>
							<%
							Orphanage o = dao2.getOrgById(p.getOrphangeId());
							%>

							<td><%=o.getOrgName()%></td>
							<td><%=p.getStatus()%></td>
							<td><a href="view_orphans.jsp?pid=<%=p.getId()%>"
								class="btn btn-sm btn-primary"><i class="fas fa-eye"></i>
									View</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>