<%@page import="com.entity.ShopDtls"%>
<%@page import="com.DAO.ShopDAOImpl"%>
<%@page import="com.entity.UserDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.UserDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: View Shop</title>
<%@include file="allCss.jsp"%>


</head>
<body style="background-color: #f0f1f2;">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty adminObj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container">

		<div class=card>
			<div class="card-body">
				<h3 class="text-center text-success p-1">All Shop List</h3>
				<c:if test="${not empty succMsg }">
					<h4 class="text-center text-success">${succMsg }</h4>
					<c:remove var="succMsg" scope="session" />
				</c:if>

				<c:if test="${not empty failedMsg }">
					<h4 class="text-center text-danger">${failedMsg }</h4>
					<c:remove var="failedMsg" scope="session" />
				</c:if>
				<table class="table mt-5">
					<thead>
						<tr>
							<th scope="col">Owner Name</th>
							<th scope="col">Shop Name</th>
							<th scope="col">Email</th>
							<th scope="col">Ph No</th>
							<th scope="col">Address</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						ShopDAOImpl dao = new ShopDAOImpl(DBConnect.getConn());
						List<ShopDtls> list = dao.getShop();
						for (ShopDtls u : list) {
						%>
						<tr>
							<td><%=u.getOwnerName()%></td>
							<td><%=u.getShopName()%></td>
							<td><%=u.getEmail()%></td>
							<td><%=u.getPhno()%></td>
							<td><%=u.getAddress()%>,<%=u.getCity()%>,<%=u.getState()%></td>
							<td><a href="../delete?id=<%=u.getId()%>&&ty=sh"
								class="btn btn-sm btn-danger"><i class="fas fa-trash"></i>
									Delete</a></td>
						</tr>
						<%
						}
						%>



					</tbody>
				</table>
			</div>
		</div>

	</div>

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="text-center">
						<h4>Do You want logout</h4>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<a href="../logout" type="button"
							class="btn btn-primary text-white">Logout</a>
					</div>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

	<!-- end logout modal -->

	<div style="margin-top: 200px;">
		<%@include file="footer.jsp"%></div>


</body>
</html>