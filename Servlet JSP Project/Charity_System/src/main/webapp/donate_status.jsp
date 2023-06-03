<%@page import="java.util.List"%>
<%@page import="com.entity.Patient"%>
<%@page import="com.dao.PatientDAOImpl"%>
<%@page import="com.entity.Donate"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.DonateDAO"%>
<%@page import="com.entity.Donor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donate Status</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty donobj}">
		<c:redirect url="login.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<a href="orphan_donate_status.jsp" class=" btn btn-info">Oprhan
					Donation</a>
				<h4 class="text-center">NGO Donation Details</h4>
				<table class="table">
					<thead class="bg-primary text-white">
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Pay to</th>
							<th scope="col">Amt</th>
							<th scope="col">Satus</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						Donor donar = (Donor) session.getAttribute("donobj");
						DonateDAO dao = new DonateDAO(DBConnect.getConn());
						List<Donate> list = dao.getDonate(donar.getId());
						for (Donate d : list) {
						%>
						<tr>
							<th scope="row"><%=d.getName()%></th>
							<%
							PatientDAOImpl daox = new PatientDAOImpl(DBConnect.getConn());
							Patient p = daox.getPatientById(d.getPid());
							%>
							<td><%=p.getName()%></td>
							<td><%=d.getAmount()%></td>
							<td><%=d.getStatus()%></td>
							<td>
								<%
								if ("Reject".equals(d.getStatus()) || "Processing".equals(d.getStatus())) {
								%>
								<p>Recipt</p> <%
 } else {
 %> <a
								href="ngo_invoice.jsp?id=<%=d.getId()%>">Recipt</a> <%
 }
 %>





							</td>
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