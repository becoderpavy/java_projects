<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.DonateDAO"%>
<%@page import="com.entity.Donate"%>
<%@page import="com.entity.Donor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scan Page Donar</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty donobj}">
		<c:redirect url="login.jsp" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3 text-center">
				<img alt="" src="img/scan.jpg" style="widows: 250px; width: 250px;"><br>
				<a href="home.jsp" class="btn btn-primary mt-3">Done</a>

				<%
				Thread.sleep(3000);
				Donor donar = (Donor) session.getAttribute("donobj");
				int pid = Integer.parseInt(request.getParameter("pid"));
				Double amt = Double.parseDouble(request.getParameter("amt"));
				int did = donar.getId();
				String name = donar.getName();
				String st = "Processing";

				Donate d = new Donate();
				d.setPid(pid);
				d.setDid(did);
				d.setName(name);
				d.setAmount(amt);
				d.setStatus(st);

				DonateDAO dao = new DonateDAO(DBConnect.getConn());
				boolean f = dao.addPayment(d);
				if (f) {
					session.setAttribute("succMsg", "Payment Sucessfully.. wait for confirmation");
					response.sendRedirect("donate.jsp?pid=" + pid);
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					response.sendRedirect("donate.jsp?pid=" + pid);
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>