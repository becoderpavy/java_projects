<%@page import="com.entity.PetDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.PetDAOImpl"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.nio.channels.ScatteringByteChannel"%>
<%@page import="com.DAO.ShopDAOImpl"%>
<%@page import="com.entity.ShopDtls"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop: View Pet</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="navbar.jsp"%>

	<c:if test="${empty shopobj}">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container">
		<div class="card">
			<div class="card-body">
				<h3 class="text-center text-success">View All Pets List</h3>
				<c:if test="${not empty succMsg }">
					<h5 class="text-center text-success">${succMsg }</h5>
					<c:remove var="succMsg" scope="session" />
				</c:if>

				<c:if test="${not empty failedMsg }">
					<h5 class="text-center text-danger">${failedMsg }</h5>
					<c:remove var="failedMsg" scope="session" />
				</c:if>
				<table class="table table-striped mt-5">
					<thead>
						<tr>
							<th scope="col">Image</th>
							<th scope="col">Category</th>
							<th scope="col">Pet Name</th>
							<th scope="col">Price</th>
							<th scope="col">Status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						ShopDtls s = (ShopDtls) session.getAttribute("shopobj");
						int id = s.getId();
						PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());
						List<PetDtls> list = dao.getPetsByShopId(id);
						for (PetDtls p : list) {
						%>
						<tr>
							<td><img alt="" src="../pet_img/<%=p.getImage()%>"
								style="width: 50px; height: 50px;"></td>
							<td><%=p.getCategory()%></td>
							<td><%=p.getPetName()%></td>
							<td><%=p.getPrice()%></td>
							<td><%=p.getStatus()%></td>
							<td><a
								href="one_views.jsp?pid=<%=p.getId()%>&&sid=<%=p.getShopid()%>"
								class="btn btn-sm btn-success"><i class="fas fa-eye"></i>
									View</a> <a
								href="edit_pet.jsp?pid=<%=p.getId()%>&&sid=<%=p.getShopid()%>"
								class="btn btn-sm btn-primary"><i class="fas fa-edit"></i>
									Edit</a> <a
								href="../delete_pet?pid=<%=p.getId()%>&&sid=<%=p.getShopid()%>"
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
	<!-- end logout modal -->

	<div style="margin-top: 200px;">
		<%@include file="footer.jsp"%></div>


</body>
</html>