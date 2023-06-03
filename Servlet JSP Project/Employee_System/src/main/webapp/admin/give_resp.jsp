<%@page import="com.emp.entity.Helpline"%>
<%@page import="com.emp.db.DBConnect"%>
<%@page import="com.emp.dao.HelplineDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Give Response</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #eceff1;">
	<c:if test="${empty userobj}">
		<c:set value="Please Login" var="failedmsg" scope="session"></c:set>
		<c:redirect url="../index.jsp"></c:redirect>
	</c:if>
	<%@include file="../common_nav/admin_nav.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<h3 class="text-center">Ticket Response</h3>

					<div class="card-body">
						<%
						int tid = Integer.parseInt(request.getParameter("tid"));
						int uid = Integer.parseInt(request.getParameter("uid"));
						HelplineDAO dao = new HelplineDAO(DBConnect.getConnection());
						Helpline h = dao.gethelpByTid(tid, uid);
						%>

						<form action="../resp_ticket" method="post">
							<div class="form-group">
								<label>Enter Title</label> <input type="text" name="ti"
									class="form-control" value="<%=h.getTitle()%>" readonly>
							</div>

							<div class="form-group">
								<label>Enter Reason</label>
								<textarea rows="3" cols="" class="form-control" name="re" readonly><%=h.getReason() %></textarea>
							</div>
							<div class="form-group">
								<label>Enter Message</label> <input type="text" name="ms"
									class="form-control">
							</div>

							<input name="uid" type="hidden" value="<%=h.getUserid()%>">
							<input name="tid" type="hidden" value="<%=h.getId()%>">
							<button class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>