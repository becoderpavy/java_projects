<%@page import="com.entity.Patient"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.PatientDAOImpl"%>
<%@page import="com.entity.Organization"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor: Home</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
/* .crd-ho:hover {
	background-color: #fcf7f7;
} */
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
	<%@include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<%
			String ca = request.getParameter("ca");
			String sql = "";
			if ("all".equals(ca)) {
				sql = "select * from patient where status='Approved' order by id desc ";
			} else {
				sql = "select * from patient where status='Approved' and category='" + ca + "'  order by id desc ";
			}
			
			PatientDAOImpl dao = new PatientDAOImpl(DBConnect.getConn());
			List<Patient> list = dao.getAllPatientByStatus(sql);
			//System.out.print(list);
			for (Patient p : list) {
			%>

			<a href="view_one_user.jsp?pid=<%=p.getId()%>">
				<div class="col-md-3 mt-2">
					<div class="card crd-ho">
						<div class="card-body text-center">
							<img alt="" src="user_img/<%=p.getImage()%>"
								style="width: 150px; height: 150px" class="img-thumblin">
							<h5 class="mt-2"><%=p.getName()%></h5>
						</div>
						<div class="card-footer">

							<c:if test="${empty donobj }">
								<a href="login.jsp"
									class="btn btn-sm btn-danger text-white ml-4"><i
									class="fas fa-hand-holding-usd"></i> Donate</a>
							</c:if>

							<c:if test="${not empty donobj }">
								<a href="donate.jsp?pid=<%=p.getId()%>"
									class="btn btn-sm btn-danger text-white ml-4"><i
									class="fas fa-hand-holding-usd"></i> Donate</a>
							</c:if>

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