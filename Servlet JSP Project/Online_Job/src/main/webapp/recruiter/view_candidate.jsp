<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Candidates</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty recObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-3">
		<h2 class="text-center">All Jobs</h2>
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
				<tr>
					<td>Mark Mark Mark Mark Mark Mark M</td>
					<td>Mark</td>
					<td>Mark</td>
					<td><a href="view_candidate.jsp"
						class="btn btn-sm btn-outline-success"><i
							class="fas fa-download"></i> Download</a></td>

				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>