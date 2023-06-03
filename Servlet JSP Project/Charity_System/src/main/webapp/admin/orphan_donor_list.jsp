<%@page import="com.entity.Orphanage"%>
<%@page import="com.entity.Orphans"%>
<%@page import="com.entity.DonateOrphan"%>
<%@page import="com.dao.OrphanageDAO"%>
<%@page import="com.dao.OrphansDAO"%>
<%@page import="com.dao.DonateOrphanDAO"%>
<%@page import="com.entity.Organization"%>
<%@page import="com.dao.OrganizationDAOImpl"%>
<%@page import="com.entity.Patient"%>
<%@page import="com.dao.PatientDAOImpl"%>
<%@page import="com.entity.Donate"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.DonateDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Donor</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adobj}">
		<c:redirect url="../login.jsp" />
	</c:if>


	<div class="container-fluid">
		<div class="card">
			<div class="card-body">
				<div class="col-md-12 text-right">
					<button onclick="window.print()" class="btn btn-danger">
						Print</button>
				</div>
				<h4 class="text-center">Orphan Donor List</h4>
				<c:if test="${not empty failedMsg }">
					<h5 class="text-center text-danger">${failedMsg}</h5>
					<c:remove var="failedMsg" scope="session" />
				</c:if>

				<c:if test="${not empty succMsg }">
					<h5 class="text-center text-success">${succMsg}</h5>
					<c:remove var="succMsg" scope="session" />
				</c:if>
				<table class="table mt-2">
					<thead>
						<tr>
							<th scope="col">Image</th>
							<th scope="col">Patient Name</th>
							<th scope="col">Problem</th>
							<th scope="col">Need Money</th>
							<th scope="col">Raised Money</th>
							<th scope="col">Organization Name</th>
							<th scope="col">Pay User</th>
							<th scope="col">Amount</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						DonateOrphanDAO dao = new DonateOrphanDAO(DBConnect.getConn());
						OrphansDAO dao2 = new OrphansDAO(DBConnect.getConn());
						OrphanageDAO dao3 = new OrphanageDAO(DBConnect.getConn());
						List<DonateOrphan> list = dao.getAllDonates();
						for (DonateOrphan d : list) {
							Orphans p = dao2.getPatientById(d.getPid());
							Orphanage or = dao3.getOrgById(p.getOrphangeId());
						%>
						<tr>

							<td><img alt="" src="../orphans_img/<%=p.getImage()%>"
								width="50px;" height="50px;"></td>
							<td><%=p.getName()%></td>
							<td><%=p.getProblem()%></td>
							<td><%=p.getNeedMoney()%></td>
							<td><%=p.getRaiseMoney()%></td>
							<td><%=or.getOrgName()%></td>
							<td><%=d.getName()%></td>
							<td><%=d.getAmount()%></td>
							<td><%=d.getStatus()%></td>
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