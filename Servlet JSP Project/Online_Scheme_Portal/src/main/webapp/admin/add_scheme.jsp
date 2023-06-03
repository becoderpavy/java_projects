<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/css.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<p class="text-center fs-3">Add Scheme</p>
					<c:if test="${not empty errorMsg}">
						<p class="fs-4 text-center text-danger">${errorMsg}</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<c:if test="${not empty succMsg}">
						<p class=" fs-4 text-center text-success">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>
					<div class="card-body">
						<form action="../addScheme" method="post"
							enctype="multipart/form-data">

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Scheme
									Name </label> <input type="text" name="schemeName" class="form-control"
									required id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Description
								</label>
								<textarea rows="3" cols="" name="description" required
									class="form-control"></textarea>
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Official
									Site </label> <input name="siteLink" type="text" class="form-control"
									required id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Published
									Date </label> <input name="publishDate" type="date"
									class="form-control" required id="exampleInputEmail1"
									aria-describedby="emailHelp">
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Category
								</label> <select class="form-control" name="category">
									<option>--choose--</option>
									<option>Student</option>
									<option>Women</option>
									<option>Farmer</option>
									<option>BPL Families</option>
									<option>Children</option>
								</select>
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Uplpad
									File </label> <input name="files" type="file" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>



							<button type="submit" class="btn btn-primary col-md-12">Submit</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>