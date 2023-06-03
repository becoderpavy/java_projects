<%@page import="com.entity.ApplyCheck"%>
<%@page import="com.dao.CheckDAO"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnect"%>
<%@page import="com.dao.AdminDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: UserInfo</title>
<%@include file="allcss.jsp"%>
</head>
<body>

	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="main_navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="left-navbar.jsp"%>
			<div class="col-md-10 offset-md-2">
				<h3 class="text-center">All Cheque</h3>


				<c:if test="${not empty failedmsg}">
					<h3 class="text-center text-danger">${failedmsg}</h3>
					<c:remove var="failedmsg" scope="session" />
				</c:if>

				<c:if test="${not empty succmsg}">
					<h3 class="text-center text-success">${succmsg}</h3>
					<c:remove var="succmsg" scope="session" />
				</c:if>


				<!-- 	<form class="form-inline" action="../accsearch" method="post">
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" id="inputPassword2"
							placeholder="Enter Account No" name="accno">
					</div>
					<button type="submit" class="btn btn-primary mb-2">Search</button>
				</form> -->

				<hr>
				<table class="table table-striped mt-5">
					<thead class="bg-primary text-light">
						<tr>
							<th scope="col">Check No</th>
							<th scope="col">Name</th>
							<th scope="col">Account No</th>
							<th scope="col">Status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<%
						CheckDAO dao2 = new CheckDAO(DbConnect.getConn());
						List<ApplyCheck> list = dao2.getAllCheck();
						for (ApplyCheck ap : list) {
						%>
						<tr>
							<th scope="row">00AA0<%=ap.getId()%></th>
							<td><%=ap.getName()%></td>
							<td><%=ap.getAccountNo()%></td>
							<td><%=ap.getStatus()%></td>
							<td><a href="check_status.jsp?id=<%=ap.getId()%>&&st=Approved"
								class="btn btn-sm btn-primary">Approve</a> <a
								href="check_status.jsp?id=<%=ap.getId()%>&&st=Reject"
								class="btn btn-sm btn-danger">Reject</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div style="margin-top: 350px">
		<%@include file="footer.jsp"%>
	</div>

	<%
	String id = request.getParameter("id");
	String status = request.getParameter("st");
	if (id != null && status != null) {

		CheckDAO dao = new CheckDAO(DbConnect.getConn());
		int idx = Integer.parseInt(id);
		boolean f = dao.updateCheckStatus(idx, status);
		if (f) {
			session.setAttribute("SucessMsg", "Check Apply Sucessfully");
			response.sendRedirect("check_status.jsp");
		} else {
			session.setAttribute("ErrorMsg", "Something wrong on server");
			response.sendRedirect("check_status.jsp");
		}

	}
	%>


</body>
</html>