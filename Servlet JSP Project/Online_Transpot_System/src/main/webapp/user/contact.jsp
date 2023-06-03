<%@page import="com.transport.entites.Feedback"%>
<%@page import="java.util.List"%>
<%@page import="com.transport.conn.DbConnect"%>
<%@page import="com.transport.dao.FeedbackDao"%>
<%@page import="com.transport.entites.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/css.jsp"%>
</head>
<body
	style="height: 90vh; background: linear-gradient(rgba(0, 0, 0, .2), rgba(0, 0, 0, .2)), url('../img/tr5.png'); background-repeat: no-repeat; background-size: cover;">
	<%@include file="navbar.jsp"%>
	<div class="container p-5	">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<p class="fs-3">Contact Us</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-5 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-5 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<hr>
						<p>
							<i class="fa-solid fa-location-dot"></i> India
						</p>
						<p>
							<i class="fa-solid fa-phone"></i> 0671 34534523
						</p>
						<p>
							<i class="fa-solid fa-envelope"></i> transpot@gmail.com
						</p>
						<%
						User user = (User) session.getAttribute("userObj");
						%>
						<form action="../send" method="post">
							<div class="mb-3">
								<label class="form-label">Message</label>
								<textarea rows="3" cols="" class="form-control" name="message"></textarea>
							</div>
							<input type="hidden" name="username"
								value="<%=user.getUserName()%>">

							<button type="submit" class="btn bg-custom text-white col-md-12">Send</button>
						</form>

					</div>
				</div>
			</div>

			<div class="col-md-8">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Response</p>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">SL No</th>
									<th scope="col">Username</th>
									<th scope="col">Message</th>
									<th scope="col">Response</th>
								</tr>
							</thead>
							<tbody>
								<%
								int i = 0;
								FeedbackDao dao = new FeedbackDao(DbConnect.getConnection());
								List<Feedback> list = dao.getFeedbackByUserName(user.getUserName());
								for (Feedback fe : list) {
									i++;
								%>
								<tr>
									<td><%=i%></td>
									<td><%=fe.getUsername()%></td>
									<td><%=fe.getMessage()%></td>
									<td><%=fe.getResponse()%></td>
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