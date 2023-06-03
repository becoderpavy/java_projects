<%@page import="com.transport.entites.Feedback"%>
<%@page import="java.util.List"%>
<%@page import="com.transport.conn.DbConnect"%>
<%@page import="com.transport.dao.FeedbackDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/css.jsp"%>
</head>
<body
	style="height: 90vh; background: linear-gradient(rgba(0, 0, 0, .2), rgba(0, 0, 0, .2)), url('../img/tr3.jpg'); background-repeat: no-repeat; background-size: cover;">
	<%@include file="navbar.jsp"%>
	<div class="container p-4">
		<div class="col-md-12">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-4 text-center">Quries</p>
					<c:if test="${not empty errorMsg}">
						<p class="fs-5 text-center text-danger">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<c:if test="${not empty succMsg}">
						<p class=" fs-5 text-center text-success">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Sl No</th>
								<th scope="col">Username</th>
								<th scope="col">Query</th>
								<th scope="col">Response</th>
								<th scope="col">Action</th>


							</tr>
						</thead>
						<tbody>

							<%
							int i = 0;
							FeedbackDao dao = new FeedbackDao(DbConnect.getConnection());
							List<Feedback> list = dao.getAllFeedback();
							for (Feedback fe : list) {
								i++;
							%>

							<tr>
								<td><%=i++%></td>
								<td><%=fe.getUsername()%></td>
								<td><%=fe.getMessage()%></td>
								<td><%=fe.getResponse()%></td>
								<td>
									<form action="../updateFb" method="post">
										
										<div style="display: flex;">

											<input type="text" class="form-control" name="response">
											<input type="hidden" name="id" value="<%=fe.getId()%>">
											<button class="btn btn-sm btn-primary ml-2">update</button>


										</div>
									</form>
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
	</div>
</body>
</html>