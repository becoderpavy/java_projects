<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
UserDetails user1 = (UserDetails) session.getAttribute("userD");

if (user1 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login..");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">

	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<%
		String updateMsg = (String) session.getAttribute("updateMsg");
		String errorMsg = (String) session.getAttribute("errorMsg");
		if (updateMsg != null) {
		%>
		<div class="alert alert-success" role="alert"><%=updateMsg%></div>
		<%
		session.removeAttribute("updateMsg");
		}

		if (errorMsg != null) {
		%>
		<div class="alert alert-danger" role="alert"><%=errorMsg%></div>
		<%
		session.removeAttribute("errorMsg");
		}
		%>


		<h1 class="text-center">Add Your Notes</h1>


		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="AddNotesServlet" method="post">
						<div class="form-group">

							<%
							UserDetails us = (UserDetails) session.getAttribute("userD");
							if (us != null) {
							%>
							<input type="hidden" value="<%=us.getId()%>" name="uid">
							<%
							}
							%>




							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" cols="" class="form-control" name="content"
								required="required"></textarea>

						</div>


						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add Notes</button>
						</div>
					</form>
				</div>
			</div>


		</div>

	</div>

	<div style="margin-top: 60px;">
		<%@include file="all_component/footer.jsp"%>
	</div>

</body>
</html>