<%@page import="com.entity.ApplyCheck"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.CheckDAO"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.dao.UserDAOImpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page isELIgnored="false"%>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>
	<c:if test="${ empty userobj}">
		<c:set value="Please Login" scope="session" var="failedmsg"></c:set>
		<c:redirect url="login.jsp" />
	</c:if>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-5">
				<div class="card">
					<div class="card-body">
						<h5 class="text-center">Apply Cheque</h5>
						<c:if test="${not empty failedmsg}">
							<p class="text-center text-danger">${sessionScope.failedmsg}</p>
							<c:remove var="failedmsg" scope="session" />
						</c:if>

						<c:if test="${not empty succmsg}">
							<p class="text-center text-success">${sessionScope.succmsg}</p>
							<c:remove var="succmsg" scope="session" />
						</c:if>
						<%
						User us = (User) session.getAttribute("userobj");
						%>

						<form action="applyCheck" method="post">
							<div class="form-group">
								<label>Full Name</label> <input type="text" name="name"
									value="<%=us.getFirstName()%> <%=us.getLastName()%>" readonly
									class="form-control">
							</div>
							<div class="form-group">
								<label>Account Number</label> <input
									value="<%=us.getAccountNo()%>" type="text" name="accountNo"
									readonly class="form-control">
							</div>
							<button class="btn btn-primary col-md-12">Apply</button>
						</form>

					</div>
				</div>
			</div>


			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h5 class="text-center">Apply Cheque</h5>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Cheque No</th>
									<th scope="col">Name</th>
									<th scope="col">Account No</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>
								<%
								CheckDAO dao2 = new CheckDAO(DbConnect.getConn());
								List<ApplyCheck> list = dao2.getAllCheckById(us.getAccountNo());
								for (ApplyCheck ap : list) {
								%>
								<tr>
									<th scope="row">00AA0<%=ap.getId()%></th>
									<td><%=ap.getName()%></td>
									<td><%=ap.getAccountNo()%></td>
									<td><%=ap.getStatus()%></td>
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