<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body style="background-color: #e5e4e2">
	<%@include file="all_component/navbar.jsp"%>

	<%
	String sucessMsg = (String) session.getAttribute("sucessMsg");
	String errorMsg = (String) session.getAttribute("errorMsg");
	%>

	<div class="container-fluid">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">


						<h5 class=" text-center text-primary">Sell Book</h5>
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

						<%
						if (user == null) {
							session.setAttribute("errorMsg", "Please Login");
							response.sendRedirect("login.jsp");
						} else {
						%>
						<form action="userAddBookServlet" method="post"
							enctype="multipart/form-data">
							<input type="hidden" value="<%=user.getEmail()%>" name="email">
							
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
								<label for="exampleFormControlFile1">Upload Photo</label> <input
									type="file" class="form-control-file"
									id="exampleFormControlFile1" name="bimg">
							</div>


							<button type="submit" class="btn btn-primary">Sell</button>
						</form>
						<%
						}
						%>

					</div>
				</div>
			</div>
		</div>
	</div>



	<div style="margin-top: 30px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>