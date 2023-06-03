<%@page import="com.entity.OrderDtls"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.OrderDAOImpl"%>
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

	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container p-1">
		<div class="row">
			<div class="col-md-10 offset-md-1" style="height: 450px">
				<div class="card">
					<div class="card-body">

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						OrderDAOImpl dao = new OrderDAOImpl(DBConnect.getConn());
						OrderDtls o = dao.getOrderById(id);
						%>
						<h3 class="text-center">Invoice</h3>

						<div class="row">
							<div class="col-md-6">
								<h5>Billing Address:</h5>
								<%=o.getUserName()%><br><%=o.getEmail()%><br><%=o.getPhno()%><br><%=o.getAddress()%>

								<p class="mt-3">
									<span class="font-weight-bold">Paymeny Type :</span>
									<%=o.getPaymentType()%></p>


								<p>
							</div>

							<div class="col-md-6 text-right">
								<p>
									<span class="font-weight-bold">Order Date :</span>
									<%=o.getDate()%></p>


								<p>
									<span class="font-weight-bold">Order Id :</span>
									<%=o.getOrderId()%></p>

								<p>
									<span class="font-weight-bold">PAN No:</span>AAJCC8517E
								</p>

								<p>
									<span class="font-weight-bold">GST Registration No :</span>19AAJCC8517E1ZI
								</p>


							</div>
						</div>
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
									<td class="p-5"><%=o.getPetName()%></td>
									<td class="p-5"><%=o.getPrice()%></td>
									<td class="p-5"><%=o.getPrice()%></td>
								</tr>
								<tr>
									<td colspan="3">Total Amount</td>
									<td class="font-weight-bold"><span class="ml-4"><%=o.getPrice()%></span></td>
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