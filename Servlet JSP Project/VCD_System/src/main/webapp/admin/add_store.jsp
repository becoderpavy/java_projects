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

	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body ">
						<p class="fs-3 text-center">Add Store Details</p>
						<c:if test="${not empty errorMsg}">
							<h5 class="text-center text-danger">${errorMsg}</h5>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="../addStore" method="post"
							enctype="multipart/form-data">
							<div class="mb-2 ">
								<label for="exampleInputEmail1" class="form-label">Store
									Name </label> <input required name="storeName" type="text" class="form-control"
									id="exampleInputEmail1">

							</div>

							<div class="mb-2 ">
								<label for="exampleInputEmail1" class="form-label">Mobile
									Number </label> <input name="mobNo" type="number" min="10" class="form-control"
									id="exampleInputEmail1">

							</div>

							<div class="mb-2">
								<label for="exampleInputEmail1" class="form-label">Address
								</label>
								<textarea  required name="address" rows="2" cols="" class="form-control"></textarea>

							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Image
								</label> <input name="img" type="file" class="form-control" required
									id="exampleInputEmail1">

							</div>

							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>

					</div>
				</div>
			</div>

			<div class="col-md-8">
				<div class="container">
					<div class="card">
						<div class="card-body ">
							<p class="fs-3 text-center">View Store</p>

							<table class="table">
								<thead>
									<tr>
										<th scope="col">Image</th>
										<th scope="col">Store Name</th>
										<th scope="col">Mobile Number</th>
										<th scope="col">Address</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody>
									<%
									StoreDAO dao = new StoreDAO(DBConnect.getConn());
									List<Store> list = dao.getAllStores();
									for (Store s : list) {
									%>
									<tr>
										<th scope="row"><img alt=""
											src="../store_img/<%=s.getStoreImg()%>" width="50px"
											height="50px"></th>
										<td><%=s.getStoreName()%></td>
										<td><%=s.getMobNo()%></td>
										<td><%=s.getAddress()%></td>
										<td><a class="btn btn-sm btn-primary"
											href="edit_store.jsp?id=<%=s.getId()%>">Edit</a> <a
											href="../deleteStore?id=<%=s.getId()%>"
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
	</div>

</body>
</html>