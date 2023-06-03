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
						<p class="fs-3 text-center">Add Movies</p>
						<c:if test="${not empty errorMsg}">
							<h5 class="text-center text-danger">${errorMsg}</h5>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="../addMovies" method="post"
							enctype="multipart/form-data">
							<div class="row mb-2">
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">VCD
										Name </label> <input required name="moviesName" type="text"
										class="form-control form-control-sm" id="exampleInputEmail1">

								</div>

								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Language
									</label> <input required name="language" type="text"
										class="form-control form-control-sm" id="exampleInputEmail1">
								</div>
							</div>

							<div class="row mb-2">
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Category
									</label> <select required name="category"
										class="form-control form-control-sm">
										<option value="Hollywood">Hollywood</option>
										<option value="Bollywood">Bollywood</option>
										<option value="Regional">Regional</option>
									</select>
								</div>
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Ratings
									</label> <input name="ratings" type="number"
										class="form-control form-control-sm" id="exampleInputEmail1">
								</div>
							</div>


							<div class="row mb-2">
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Quantity
									</label> <input required name="quantity" type="number"
										class="form-control form-control-sm" id="exampleInputEmail1">
								</div>
								<div class="col">
									<label for="exampleInputEmail1" class="form-label">Cost
									</label> <input required name="cost" type="number"
										class="form-control form-control-sm" id="exampleInputEmail1">
								</div>
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Description
								</label>
								<textarea required name="description" rows="3" cols=""
									class="form-control"></textarea>
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Store
									Name </label> <select name="storeId" required class="form-control">
									<option>--choose--</option>
									<%
									StoreDAO dao = new StoreDAO(DBConnect.getConn());
									List<Store> list = dao.getAllStores();
									for (Store s : list) {
									%>
									<option value="<%=s.getId()%>"><%=s.getStoreName()%></option>
									<%
									}
									%>
								</select>
							</div>

							<div class="mb-3 ">
								<label for="exampleInputEmail1" class="form-label">Image
								</label> <input required name="img" type="file"
									class="form-control form-control-sm" id="exampleInputEmail1">
							</div>

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