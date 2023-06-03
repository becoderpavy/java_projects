<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss_file.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container-fluid">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<form action="../AdminAddBookServlet" method="post" enctype="multipart/form-data">

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
								<label for="inputState">Book Type</label> <select id="inputState" name="btype"
									class="form-control">
									<option selected>--select--</option>
									<option value="newbook">New Book</option>
									<option value="oldbook">Old Book</option>
								</select>
							</div>
							
								<div class="form-group">
								<label for="inputState">Book Status</label> <select id="inputState" name="bstatus"
									class="form-control">
									<option selected>--select--</option>
									<option value="active">Active</option>
									<option value="inactive">Inactive</option>
								</select>
							</div>

							<div class="form-group">
								<label for="exampleFormControlFile1">Upload Photo</label> <input name="bimg"
									type="file" class="form-control-file"
									id="exampleFormControlFile1">
							</div>


							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>