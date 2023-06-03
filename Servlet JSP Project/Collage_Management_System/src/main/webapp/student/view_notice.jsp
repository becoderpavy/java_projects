<%@page import="com.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.admin.dao.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student : View Notice</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">
	<c:if test="${empty sobj }">
		<c:redirect url="../slogin.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>


			<div class="col-md-10">
				<i class="fas fa-bars m-2 fa-2x" onclick="toogleSidebar()"></i>

				<div class="container-fluid">
					<%
					NoticeDAO dao = new NoticeDAO(DBConnect.getConn());
					List<Notice> list = dao.getNotice();
					for (Notice n : list) {
					%>
					<div class="card mt-2">
						<div class="card-body">
							<div class="text-center text-danger">
								<i class="far fa-clipboard fa-2x"></i>
							</div>
							<h6>
								Publish By:
								<%=n.getName()%></h6>
							<h6>
								Date :
								<%=n.getDate().toString()%></h6>
							<p><%=n.getMessage()%></p>
							<br>


						</div>
					</div>
					<%
					}
					%>



				</div>
			</div>
		</div>
	</div>
</body>
</html>