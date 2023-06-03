<%@page import="com.entites.Store"%>
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
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body ">
						<p class="fs-3 text-center">Edit Store Details</p>
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						StoreDAO dao = new StoreDAO(DBConnect.getConn());
						Store s = dao.getStoreById(id);
						%>
						<form action="../updateStore" method="post"
							enctype="multipart/form-data">
							<div class="mb-2 ">
								<label for="exampleInputEmail1" class="form-label">Store
									Name </label> <input value="<%=s.getStoreName()%>" name="storeName"
									type="text" class="form-control" id="exampleInputEmail1">

							</div>

							<div class="mb-2 ">
								<label for="exampleInputEmail1" class="form-label">Mobile
									Number </label> <input value="<%=s.getMobNo()%>" name="mobNo"
									type="text" class="form-control" id="exampleInputEmail1">

							</div>

							<div class="mb-2">
								<label for="exampleInputEmail1" class="form-label">Address
								</label>
								<textarea name="address" rows="2" cols="" class="form-control"><%=s.getAddress()%></textarea>

							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Image
								</label> <input name="img" type="file" class="form-control"> <small>uploaded
									img: <%=s.getStoreImg()%></small>

							</div>
							<input type="hidden" name="id" value="<%=s.getId()%>">
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>