<%@page import="com.entites.Store"%>
<%@page import="com.dao.StoreDAO"%>
<%@page import="com.entites.Movies"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.MoviesDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allCss.jsp"%>
</head>
<body>
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../component/admin_navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12 ">
				<div class="card">
					<div class="card-body ">
						<p class="fs-3 text-center">View VCD</p>
						<c:if test="${not empty errorMsg}">
							<h5 class="text-center text-danger">${errorMsg}</h5>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Image</th>
									<th scope="col">Store Name</th>
									<th scope="col">Name</th>
									<th scope="col">Language</th>
									<th scope="col">Category</th>
									<th scope="col">Ratings</th>
									<th scope="col">Quantity</th>
									<th scope="col">Cost</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								MoviesDAO dao = new MoviesDAO(DBConnect.getConn());
								StoreDAO dao2 = new StoreDAO(DBConnect.getConn());
								List<Movies> list = dao.getAllMovies();
								for (Movies m : list) {
									Store s = dao2.getStoreById(m.getStoreId());
								%>
								<tr>
									<th scope="row"><img src="../movies_img/<%=m.getImg()%>"
										width="50px" height="50px"></th>
									<td><%=s.getStoreName()%></td>
									<td><%=m.getMoviesName()%></td>
									<td><%=m.getLanguage()%></td>
									<td><%=m.getCategory()%></td>
									<td><%=m.getRatings()%></td>
									<td><%=m.getQuantity()%></td>
									<td><%=m.getCost()%></td>
									<td><a class="btn btn-sm btn-primary"
										href="edit_vcd.jsp?id=<%=m.getId()%>">Edit</a> <a
										href="../deleteMovies?id=<%=m.getId()%>"
										class="btn btn-sm btn-danger ">Delete</a></td>
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
</body>
</html>