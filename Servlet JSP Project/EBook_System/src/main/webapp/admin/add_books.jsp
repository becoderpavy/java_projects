<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.entity.userDtls"%>
<%
userDtls user1 = (userDtls) session.getAttribute("admin");
if (user1 == null) {
	response.sendRedirect("../login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook:Admin Add Book</title>
<%@include file="allCss_file.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<%
	String sucessMsg = (String) session.getAttribute("sucessMsg");
	String errorMsg = (String) session.getAttribute("errorMsg");
	%>


	<div class="container-fluid">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<h5 class="text-primary">Book Add</h5>
						</div>
						<%
						if (sucessMsg != null) {
						%>
						<p class="text-success"><%=sucessMsg%></p>
						<%
						session.removeAttribute("sucessMsg");
						}

						if (errorMsg != null) {
						%>
						<p class="text-danger"><%=errorMsg%></p>
						<%
						session.removeAttribute("errorMsg");
						}
						%>

						<form action="../AdminAddBookServlet" method="post"
							enctype="multipart/form-data">

							<div class="form-group">
								<label for="exampleInputEmail1">Book Name*</label> <input
									name="bname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Author Name*</label> <input
									name="author" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputPassword1">
							</div>

							<div class="form-group">
								<label for="inputState">Book Categories</label> <select
									id="inputState" name="btype" class="form-control">
									<option selected>--select--</option>
									<option value="New">New Book</option>
								</select>
							</div>

							<div class="form-group">
								<label for="inputState">Book Status</label> <select
									id="inputState" name="bstatus" class="form-control">
									<option selected>--select--</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
								</select>
							</div>

							<div class="form-group">
								<label for="exampleFormControlFile1">Upload Photo</label> <input
									name="bimg" type="file" class="form-control-file"
									id="exampleFormControlFile1">
							</div>


							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div style="margin-top: 30px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>