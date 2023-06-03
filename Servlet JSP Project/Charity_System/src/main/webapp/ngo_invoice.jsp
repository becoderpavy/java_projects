<%@page import="com.entity.Patient"%>
<%@page import="com.dao.PatientDAOImpl"%>
<%@page import="com.entity.Donate"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.DonateDAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
</head>
<body style="background-color: #f0f1f2;">

	<c:if test="${empty donobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container p-1">
		<div class="row">
			<div class="col-md-10 offset-md-1" style="height: 450px">
				<div class="card">
					<div class="card-body">

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						DonateDAO dao = new DonateDAO(DBConnect.getConn());
						Donate d = dao.getDonateById(id);

						PatientDAOImpl dao2 = new PatientDAOImpl(DBConnect.getConn());
						Patient p = dao2.getPatientById(d.getPid());
						%>
						<h3 class="text-center">Invoice</h3>


						<table class="table table-bordered">
							<thead class="bg-light">
								<tr>
									<th scope="col">SL No</th>
									<th scope="col">Description</th>
									<th scope="col">Net Amount</th>
									<th scope="col">Total Amount</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th class="p-5" scope="row">1</th>
									<td class="p-5">Pay to :  <%=p.getName()%> <br> Problem
										: <%=p.getProblem()%><br> Category : <%=p.getCategory()%>

									</td>
									<td class="p-5"><%=d.getAmount()%></td>
									<td class="p-5"><%=d.getAmount()%></td>
								</tr>
								<tr>
									<td colspan="3">Total Amount</td>
									<td class="font-weight-bold"><span class="ml-4"><%=d.getAmount()%></span></td>
								</tr>

							</tbody>
						</table>
						<div class="text-center">
							<button class="btn btn-primary" onclick="window.print();">Print</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 	<script type="text/javascript">
		function print() {
			window.print();
		}
	</script> -->
</body>
</html>