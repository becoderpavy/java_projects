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
				<h3 class="text-center">All Account</h3>


				<c:if test="${not empty failedmsg}">
					<h3 class="text-center text-danger">${failedmsg}</h3>
					<c:remove var="failedmsg" scope="session" />
				</c:if>

				<c:if test="${not empty succmsg}">
					<h3 class="text-center text-success">${succmsg}</h3>
					<c:remove var="succmsg" scope="session" />
				</c:if>


				<form class="form-inline" action="../accsearch" method="post">
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" id="inputPassword2"
							placeholder="Enter Account No" name="accno">
					</div>
					<button type="submit" class="btn btn-primary mb-2">Search</button>
				</form>

				<hr>
				<table class="table table-striped mt-5">
					<thead class="bg-primary text-light">
						<tr>
							<th scope="col">Account No</th>
							<th scope="col">Status</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Phone No</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<c:if test="${empty accUser}">
							<%
							AdminDAOImpl dao = new AdminDAOImpl(DbConnect.getConn());
							List<User> list = dao.allAccount();
							for (User sts : list) {
							%>
							<tr>
								<th scope="row"><%=sts.getAccountNo()%></th>
								<td><%=sts.getStatus()%></td>
								<td><%=sts.getFirstName() + " " + sts.getLastName()%></td>
								<td><%=sts.getEmail()%></td>
								<td><%=sts.getNumber()%></td>
								<td><a class="btn btn-success btn-sm"
									href="../view?accno=<%=sts.getAccountNo()%>">View</a> <a
									href="../edit_view?accno=<%=sts.getAccountNo()%>"
									class="btn btn-sm btn-primary text-white">Edit</a></td>
							</tr>
							<%
							}
							%>
						</c:if>


						<c:if test="${not empty accUser}">
							<tr>
								<th scope="row">${accUser.accountNo}</th>
								<td>${accUser.status}</td>
								<td>${accUser.firstName}${accUser.lastName}</td>
								<td>${accUser.email }</td>
								<td>${accUser.number }</td>
								<td><a class="btn btn-success btn-sm"
									href="../view?accno=${accUser.accountNo}">View</a> <a
									href="../edit_view?accno=${accUser.accountNo}"
									class="btn btn-sm btn-primary text-white">Edit</a></td>
							</tr>
							<c:remove var="accUser" />
						</c:if>
						<c:if test="${not empty failedMsg}">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" />
						</c:if>
					</tbody>
				</table>


			</div>
		</div>
	</div>
	<div style="margin-top: 350px">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>