
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.entity.Paintings"%>
<%@page import="com.entity.Artist"%>
<%@page import="com.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.ArtistDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ARTIST | Edit Paintings</title>
<%@include file="../component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

.clink {
	text-decoration: none;
}
</style>
</head>
<body>
	<c:if test="${ empty artObj }">
		<c:redirect url="../alogin.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-4">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Edit Paintings</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>


						<%
						ArtistDAO dao = new ArtistDAO(DBConnect.getConnection());
						int pid = Integer.parseInt(request.getParameter("id"));

						//Artist art = (Artist) session.getAttribute("artObj");
						int artIid = Integer.parseInt(request.getParameter("artid"));

						Paintings paint = dao.getPaintById(pid, artIid);
						/* out.print(pid + " " + paint + " " + artIid); */
						%>
						<form action="../update_paint" method="post">
							<input required type="hidden" name="id"
								value="<%=paint.getId()%>">
							<div class="mb-3">
								<label class="form-label">Name</label> <input required
									type="text" name="name" value="<%=paint.getName()%>"
									class="form-control form-control-sm">
							</div>
							<div class="mb-3">
								<label class="form-label">Description</label> <input required
									type="text" name="description"
									value="<%=paint.getDescription()%>"
									class="form-control form-control-sm">
							</div>
							<div class="mb-3">
								<label class="form-label">Price</label> <input required
									type="text" name="price" value="<%=paint.getPrice()%>"
									class="form-control form-control-sm">
							</div>

							<div class="mb-3">
								<label class="form-label">Category</label> <select
									name="category" class="form-control form-control-sm">
									<option value="<%=paint.getCategory()%>"><%=paint.getCategory()%></option>

									<%
									List<Category> list = dao.getCategory();
									for (Category c : list) {
									%>
									<option value="<%=c.getCategoryName()%>"><%=c.getCategoryName()%></option>
									<%
									}
									%>
								</select>
							</div>
							<!-- <div class="mb-3">
								<label class="form-label">Image</label> <input type="file"
									name="img" class="form-control form-control-sm">
							</div> -->

							<button type="submit" class="btn bg-primary text-white col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>


			<%-- <div class="col-md-8">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Category Details</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Image</th>
									<th scope="col">Name</th>
									<th scope="col">Category</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Artist art = (Artist) session.getAttribute("artObj");
								List<Paintings> list2 = dao.getPaintByArtId(art.getId());
								for (Paintings p : list2) {
								%>
								<tr>
									<th scope="row"><img
										src="../paint_img/<%=p.getImageName()%>" width="50Px"
										height="50px"></th>
									<td><%=p.getName()%></td>
									<td><%=p.getCategory()%></td>
									<td><%=p.getPrice()%></td>
									<td><a
										href="edit_paint.jsp?id=<%=p.getId()%>&&artid=<%=p.getArt_id()%>"
										class="btn btn-outline-primary btn-sm">Edit</a> <a
										href="delete_paint?id=<%=p.getId()%>&&artid=<%=p.getArt_id()%>"
										class="btn btn-outline-primary btn-sm">Delete</a></td>
								</tr>
								<%
								}
								%>


							</tbody>
						</table>
					</div>
				</div>
			</div> --%>

		</div>
	</div>
</body>
</html>