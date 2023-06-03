<%@page import="com.entity.Orphans"%>
<%@page import="com.dao.OrphansDAO"%>
<%@page import="com.entity.Orphanage"%>
<%@page import="com.entity.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.PatientDAOImpl"%>
<%@page import="com.entity.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NGO: View User</title>
<%@include file="allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcf7f7;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty orphanObj}">
		<c:redirect url="../orphans_login.jsp" />
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row">
			<%
			Orphanage pa = (Orphanage) session.getAttribute("orphanObj");
			OrphansDAO dao = new OrphansDAO(DBConnect.getConn());
			List<Orphans> list = dao.getAllPatientByOrg(pa.getId());
			for (Orphans p : list) {
			%>

			<a href="view_one_user.jsp?pid=<%=p.getId()%>&&oid=<%=pa.getId()%>">
				<div class="col-md-3 mt-2">
					<div class="card crd-ho">
						<div class="card-body text-center">
							<img alt="" src="../orphans_img/<%=p.getImage()%>"
								style="width: 150px; height: 150px" class="img-thumblin">
							<h5 class="mt-2"><%=p.getName()%></h5>
						</div>
						<div class="card-footer">
							<%
							if ("Approved".equals(p.getStatus())) {
							%>
							<a class="btn btn-sm btn-success text-white"><i
								class="fas fa-check-circle"></i> Approved</a>
							<%
							} else if ("Pending".equals(p.getStatus())) {
							%>
							<a class="btn btn-sm btn-warning text-white ml-5"><i
								class="fas fa-clock"></i> Pending</a>
							<%
							} else {
							%>
							<a class="btn btn-sm btn-danger text-white"><i
								class="fas fa-times-circle"></i> Reject</a>
							<%
							}
							%>
							<a class="btn btn-sm btn-primary text-white"><i
								class="fas fa-rupee-sign"></i> <%=p.getRaiseMoney()%></a>
						</div>
					</div>
				</div>
			</a>
			<%
			}
			%>
		</div>
	</div>
</body>

</html>