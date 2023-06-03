<%@page import="com.emp.entity.Expenses"%>
<%@page import="com.emp.dao.ExpenseDAO"%>
<%@page import="com.emp.dao.UserDAO"%>
<%@page import="com.emp.entity.Resign"%>
<%@page import="com.emp.dao.ResignDAO"%>
<%@page import="com.emp.entity.Leave"%>
<%@page import="com.emp.dao.LeaveDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.emp.db.DBConnect"%>
<%@page import="com.emp.dao.AttendanceDAO"%>
<%@page import="com.emp.entity.Attendance"%>
<%@page import="com.emp.entity.UserDtls"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.nav .nav-item .nav-link {
	font-size: 30px;
}
</style>


<style type="text/css">
</style>

</head>
<body>
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="../index.jsp"></c:redirect>
	</c:if>
	<%@include file="../common_nav/admin_nav.jsp"%>
<body style="background-color: #eceff1;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="forgot">
					<h3 class="display-4 text-center">Status</h3>
					<c:if test="${not empty failedMsg}">
						<h5 class="text-center text-danger">${failedMsg}</h5>
						<c:remove var="failedMsg" scope="session" />
					</c:if>

					<c:if test="${not empty succMsg}">
						<h5 class="text-center text-success">${succMsg}</h5>
						<c:remove var="succMsg" scope="session" />
					</c:if>

				</div>

				<div class="card">
					<div class="card-body">
						<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="pills-home-tab" data-toggle="pill" href="#at" role="tab"
								aria-controls="pills-home" aria-selected="true">Attendance</a></li>
							<li class="nav-item"><a class="nav-link"
								id="pills-profile-tab" data-toggle="pill" href="#le" role="tab"
								aria-controls="pills-profile" aria-selected="false">Leave</a></li>
							<li class="nav-item"><a class="nav-link"
								id="pills-contact-tab" data-toggle="pill" href="#ex" role="tab"
								aria-controls="pills-contact" aria-selected="false">Expense</a>
							</li>

							<li class="nav-item"><a class="nav-link"
								id="pills-contact-tab" data-toggle="pill" href="#re" role="tab"
								aria-controls="pills-contact" aria-selected="false">Resignation</a>
							</li>
						</ul>
						<div class="tab-content" id="pills-tabContent">

							<div class="tab-pane fade show active" id="at" role="tabpanel"
								aria-labelledby="pills-home-tab">

								<table class="table">
									<thead>
										<tr>
											<th scope="col">Name</th>
											<th scope="col">Email</th>
											<th scope="col">Contact No</th>
											<th scope="col">Account Name</th>
											<th scope="col">Date</th>
											<th scope="col">Hours</th>
											<th scope="col">Status</th>
										</tr>
									</thead>
									<tbody>
										<%
										AttendanceDAO dao = new AttendanceDAO(DBConnect.getConnection());
										UserDAO dao5 = new UserDAO(DBConnect.getConnection());
										List<Attendance> list = dao.getAllAttend();
										for (Attendance a : list) {
											UserDtls u = dao5.getUser(a.getUserid());
										%>


										<tr>
											<td><%=u.getFirstName()%> <%=u.getLastName()%></td>
											<td><%=u.getEmail()%></td>
											<td><%=u.getContactNo()%></td>
											<td><%=a.getAccountName()%></td>
											<td><%=a.getDate()%></td>
											<td><%=a.getHours()%></td>
											<td>
												<%
												if (a.getStatus().equals("Approved")) {
												%>
												<button class="btn btn-success text-white">
													<i class="fas fa-check-circle"></i> Approved
												</button> <%
 } else if (a.getStatus().equals("Rejected")) {
 %>
												<button class="btn btn-danger text-white">
													<i class="fas fa-times-circle"></i> Rejected
												</button> <%
 } else {
 %> <a
												href="../updatestatus?uid=<%=a.getUserid()%>&&st=ap&&ty=at&&tyno=<%=a.getId()%>"
												class="btn btn-success text-white "> <i
													class="fas fa-check-circle"></i> Approve
											</a> <a
												href="../updatestatus?uid=<%=a.getUserid()%>&&st=re&&ty=at&&tyno=<%=a.getId()%>"
												class="btn btn-danger text-white "> <i
													class="fas fa-times-circle"></i> Reject
											</a> <%
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

							<div class="tab-pane fade" id="le" role="tabpanel"
								aria-labelledby="pills-profile-tab">
								<table class="table">
									<thead>
										<tr>
											<th scope="col">Name</th>
											<th scope="col">Email</th>
											<th scope="col">Contact No</th>
											<th scope="col">Leave Type</th>
											<th scope="col">From Date</th>
											<th scope="col">To Date</th>
											<th scope="col">No Of Days</th>
											<th scope="col">Status</th>
										</tr>
									</thead>
									<tbody>
										<%
										LeaveDAO dao2 = new LeaveDAO(DBConnect.getConnection());
										List<Leave> list2 = dao2.getAllLeave();
										for (Leave l : list2) {
											UserDtls u = dao5.getUser(l.getUserId());
										%>
										<tr>
											<td><%=u.getFirstName()%> <%=u.getLastName()%></td>
											<td><%=u.getEmail()%></td>
											<td><%=u.getContactNo()%></td>
											<td><%=l.getLeaveType()%></td>
											<td><%=l.getDate_from()%></td>
											<td><%=l.getDate_to()%></td>
											<td><%=l.getDays()%></td>
											<td>
												<%
												if (l.getStatus().equals("Approved")) {
												%>
												<button class="btn btn-success text-white">
													<i class="fas fa-check-circle"></i> Approved
												</button> <%
 } else if (l.getStatus().equals("Rejected")) {
 %>
												<button class="btn btn-danger text-white">
													<i class="fas fa-times-circle"></i> Rejected
												</button> <%
 } else {
 %> <a
												href="../updatestatus?uid=<%=l.getUserId()%>&&st=ap&&ty=le&&tyno=<%=l.getId()%>"
												class="btn btn-success text-white "> <i
													class="fas fa-check-circle"></i> Approve
											</a> <a
												href="../updatestatus?uid=<%=l.getUserId()%>&&st=re&&ty=le&&tyno=<%=l.getId()%>"
												class="btn btn-danger text-white "> <i
													class="fas fa-times-circle"></i> Reject
											</a> <%
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


							<div class="tab-pane fade" id="ex" role="tabpanel"
								aria-labelledby="pills-contact-tab">



								<table class="table">
									<thead>
										<tr>
											<th scope="col">Name</th>
											<th scope="col">Email</th>
											<th scope="col">Contact No</th>
											<th scope="col">Account Name</th>
											<th scope="col">Expense type</th>
											<th scope="col">Expense Date</th>
											<th scope="col">Amount</th>
											<th scope="col">Document</th>
											<th scope="col">Status</th>
										</tr>
									</thead>
									<tbody>
										<%
										ExpenseDAO dao6 = new ExpenseDAO(DBConnect.getConnection());
										List<Expenses> list6 = dao6.getAllExpense();
										for (Expenses e : list6) {
											UserDtls u = dao5.getUser(e.getUserid());
										%>
										<tr>
											<td><%=u.getFirstName()%> <%=u.getLastName()%></td>
											<td><%=u.getEmail()%></td>
											<td><%=u.getContactNo()%></td>
											<td><%=e.getAccountName()%></td>
											<td><%=e.getExpenseType()%></td>
											<td><%=e.getExpenseDate()%></td>
											<td><%=e.getAmount()%></td>
											<td><a
												href="../file_download?fn=<%=e.getDocumentName()%>"
												class="btn btn-primary"><i class="fas fa-download"></i>
													Download</a></td>

											<td>
												<%
												if (e.getStatus().equals("Approved")) {
												%>
												<button class="btn btn-success text-white">
													<i class="fas fa-check-circle"></i> Approved
												</button> <%
 } else if (e.getStatus().equals("Rejected")) {
 %>
												<button class="btn btn-danger text-white">
													<i class="fas fa-times-circle"></i> Rejected
												</button> <%
 } else {
 %> <a
												href="../updatestatus?uid=<%=e.getUserid()%>&&st=ap&&ty=ex&&tyno=<%=e.getId()%>"
												class="btn btn-success text-white btn-sm "> <i
													class="fas fa-check-circle"></i> Approve
											</a> <a
												href="../updatestatus?uid=<%=e.getUserid()%>&&st=re&&ty=ex&&tyno=<%=e.getId()%>"
												class="btn btn-danger text-white btn-sm"> <i
													class="fas fa-times-circle"></i> Reject
											</a> <%
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

							<div class="tab-pane fade" id="re" role="tabpanel"
								aria-labelledby="pills-contact-tab">
								<table class="table">
									<thead>
										<tr>
											<th scope="col">Resignation Type</th>
											<th scope="col">Resign Date</th>
											<th scope="col">Last Working Date</th>
											<th scope="col">Notice Sufered</th>
											<th scope="col">Status</th>
										</tr>
									</thead>
									<tbody>
										<%
										ResignDAO dao3 = new ResignDAO(DBConnect.getConnection());
										List<Resign> list3 = dao3.getAllResign();
										for (Resign r : list3) {
											UserDtls u = dao5.getUser(r.getUserId());
										%>
										<tr>
											<td><%=u.getFirstName()%> <%=u.getLastName()%></td>
											<td><%=u.getEmail()%></td>
											<td><%=u.getContactNo()%></td>
											<td><%=r.getResignType()%></td>
											<td><%=r.getResignDate()%></td>
											<td><%=r.getLastWorkingDate()%></td>
											<td><%=r.getNoticeSuferd()%></td>
											<td>
												<%
												if (r.getStatus().equals("Approved")) {
												%>
												<button class="btn btn-success text-white">
													<i class="fas fa-check-circle"></i> Approved
												</button> <%
 } else if (r.getStatus().equals("Rejected")) {
 %>
												<button class="btn btn-danger text-white">
													<i class="fas fa-times-circle"></i> Rejected
												</button> <%
 } else {
 %> <a
												href="../updatestatus?uid=<%=r.getUserId()%>&&st=ap&&ty=re&&tyno=<%=r.getId()%>"
												class="btn btn-success text-white "> <i
													class="fas fa-check-circle"></i> Approve
											</a> <a
												href="../updatestatus?uid=<%=r.getUserId()%>&&st=re&&ty=re&&tyno=<%=r.getId()%>"
												class="btn btn-danger text-white "> <i
													class="fas fa-times-circle"></i> Reject
											</a> <%
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
				</div>

			</div>
		</div>
	</div>
</body>
</html>
