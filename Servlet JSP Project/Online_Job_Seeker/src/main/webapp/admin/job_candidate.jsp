
<%@page import="com.db.DBConnect"%>
<%@page import="com.entites.Candidates"%>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<%@page import="com.dao.CandidatesDao"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Candidates By Job</title>
<%@include file="../all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../all_component/admin_navbar.jsp"%>
	<div class="container p-3">
		<h2 class="text-center">Candidates</h2>
		<table class="table">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">Full Name</th>
					<th scope="col">Email</th>
					<th scope="col">Mobile No</th>
					<th scope="col">Resume</th>
				</tr>
			</thead>
			<tbody class="bg-white">
				<%
				int jid = Integer.parseInt(request.getParameter("jid"));
				CandidatesDao dao = new CandidatesDao(DBConnect.getConn());
				List<Candidates> list = dao.getByJobId(jid);
				for (Candidates c : list) {
				%>
				<tr>
					<td><%=c.getFullName()%></td>
					<td><%=c.getEmail()%></td>
					<td><%=c.getMobno()%></td>
					<td><a href="../apdownloadFile?fileName=<%=c.getResume()%>"
						class="btn btn-sm btn-success"><i class="fas fa-download"></i>
							Download</a></td>

				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>
</body>
</html>