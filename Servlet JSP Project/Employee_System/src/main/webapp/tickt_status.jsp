<%@page import="java.util.List"%>
<%@page import="com.emp.entity.Helpline"%>
<%@page import="com.emp.db.DBConnect"%>
<%@page import="com.emp.dao.HelplineDAO"%>
<%@page import="com.emp.entity.UserDtls"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Status Page</title>
<link href="css/side.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<%@include file="common_nav/empnav.jsp"%>
<body style="background-color: #eceff1;">
	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<h3 class="text-center">Emplyoee Ticket Status</h3>

					<div class="card-body">

						<table class="table m-1">
							<thead class="bg-success text-white">
								<tr>
									<th scope="col">Title</th>
									<th scope="col">Reason</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody class="bg-light">
								<%
								UserDtls u = (UserDtls) session.getAttribute("userobj");
								int id = u.getId();
								HelplineDAO dao = new HelplineDAO(DBConnect.getConnection());
								List<Helpline> list = dao.gethelpById(id);
								for (Helpline h : list) {
								%>
								<tr>
									<td><%=h.getTitle()%></td>
									<td><%=h.getReason()%></td>
									<td><%=h.getStatus()%></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>