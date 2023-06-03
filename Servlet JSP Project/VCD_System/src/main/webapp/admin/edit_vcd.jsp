<%@page import="com.entites.Movies"%>
<%@page import="com.dao.MoviesDAO"%>
<%@page import="com.entites.Store"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.StoreDAO"%>
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
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body ">
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						MoviesDAO dao = new MoviesDAO(DBConnect.getConn());
						StoreDAO dao2 = new StoreDAO(DBConnect.getConn());
						List<Store> list = dao2.getAllStores();

						Movies m = dao.getMoviesById(id);
						Store s = dao2.getStoreById(m.getStoreId());
						%>
						<p class="fs-3 text-center">Edit Movies</p>

						<form action="../updateMovies" method="post"
							enctype="multipart/form-data">
							<div class="row mb-2">
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">VCD
										Name </label> <input value="<%=m.getMoviesName()%>" required
										name="moviesName" type="text"
										class="form-control form-control-sm" id="exampleInputEmail1">

								</div>

								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Language
									</label> <input value="<%=m.getLanguage()%>" required name="language"
										type="text" class="form-control form-control-sm"
										id="exampleInputEmail1">
								</div>
							</div>

							<div class="row mb-2">
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Category
									</label> <select required name="category"
										class="form-control form-control-sm">
										<option value="<%=m.getCategory()%>"><%=m.getCategory()%></option>
										<option value="Hollywood">Hollywood</option>
										<option value="Bollywood">Bollywood</option>
										<option value="Regional">Regional</option>
									</select>
								</div>
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Ratings
									</label> <input value="<%=m.getRatings()%>" name="ratings"
										type="number" class="form-control form-control-sm"
										id="exampleInputEmail1">
								</div>
							</div>


							<div class="row mb-2">
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Quantity
									</label> <input value="<%=m.getQuantity()%>" required name="quantity"
										type="number" class="form-control form-control-sm"
										id="exampleInputEmail1">
								</div>
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Cost
									</label> <input value="<%=m.getCost()%>" required name="cost"
										type="number" class="form-control form-control-sm"
										id="exampleInputEmail1">
								</div>
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Description
								</label>
								<textarea required name="description" rows="3" cols=""
									class="form-control"><%=m.getDescription()%></textarea>
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Store
									Name </label> <select name="storeId" required class="form-control">
									<option value="<%=s.getId()%>"><%=s.getStoreName()%></option>
									<%
									for (Store ss : list) {
									%>
									<option value="<%=s.getId()%>"><%=ss.getStoreName()%></option>
									<%
									}
									%>
								</select>
							</div>

							<div class="mb-3 ">
								<label for="exampleInputEmail1" class="form-label">Image
								</label> <input name="img" type="file"
									class="form-control form-control-sm" id="exampleInputEmail1">
								<strong>uploaded img:<%=m.getImg()%></strong>
							</div>
							<input type="hidden" name="id" value="<%=m.getId()%>">
							<button type="submit"
								class="btn btn-primary col-md-4 offset-md-4">Submit</button>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>