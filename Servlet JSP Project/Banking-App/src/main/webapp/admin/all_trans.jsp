<%@page import="com.entity.AccountTransaction"%>
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
<title>Admin: All Transaction</title>
<%@include file="allcss.jsp"%>
</head>
<body>
	<%@include file="main_navbar.jsp"%>
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp" />
	</c:if>
	<div class="container-fluid">
		<div class="row">
			<%@include file="left-navbar.jsp"%>
			<div class="col-md-10 offset-md-2">
				<h1 class="text-center">All Transaction</h1>

<!-- 
				<div class="col-md-5 offset-md-4 mt-5">
					<form class="form-inline" action="../serch_trans" method="post">
						<div class="form-group mx-sm-3 mb-2">
							<input type="text" class="form-control" id="inputPassword2"
								placeholder="Enter Account No" name="accno">
						</div>
						<button type="submit" class="btn btn-primary mb-2">Search</button>
					</form>
				</div> -->

				<hr>
				<table class="table table-striped mt-5">
					<thead class="bg-primary text-light">
						<tr>
							<th scope="col">Account No</th>
							<th scope="col">Credit / Debit</th>
							<th scope="col">Transaction Details</th>
							<th scope="col">Date</th>
							<th scope="col">Time</th>
							<th scope="col">Amount</th>

						</tr>
					</thead>
					<tbody>
						<%
						AdminDAOImpl dao = new AdminDAOImpl(DbConnect.getConn());
						List<AccountTransaction> trans = dao.getAllTrans();
						for (AccountTransaction tr : trans) {
						%>
						<tr>
							<th scope="row"><%=tr.getAccno()%></th>
							<td><%=tr.getTransType()%></td>
							<td><%=tr.getTransDtls()%></td>
							<td><%=tr.getTransDate()%></td>
							<td><%=tr.getTransTime()%></td>
							<td><%=tr.getBalance()%></td>
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