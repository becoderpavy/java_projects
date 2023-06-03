
<%
userDtls user1 = (userDtls) session.getAttribute("LoginUser");
if (user1 == null) {
	session.setAttribute("errorMsg", "Login Again..");
	response.sendRedirect("login.jsp");
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body style="background-color: #DCDCDC">
	<%@include file="/all_component/navbar.jsp"%>



	<div class="container-fluid">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<h5 class="text-center text-primary">Edit Profile</h5>
					<%
					String msg = (String) session.getAttribute("errorMsg");
					if (msg != null) {
					%>
					<h5 class="text-center text-danger"><%=msg%></h5>
					<%
					session.removeAttribute("errorMsg");
					}
					%>
					<div class="card-body">

						<%
						if (user != null) {
						%>
						<form action="editProfile" method="post">
							<input type="hidden" value="<%=user.getId()%>" name="id">
							<div class="form-group">
								<label for="exampleInputEmail1">Name*</label> <input name="name"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="name"
									value="<%=user.getName()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address*</label> <input
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									email="email" value="<%=user.getEmail()%>">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Phone*</label> <input
									name="phno" type="number" class="form-control"
									id="exampleInputPassword1" value="<%=user.getPhno()%>"
									name="phno">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password*</label> <input
									name="password" type="password" class="form-control"
									id="exampleInputPassword1" required="required" name="password">
							</div>
							<button type="submit" class="btn btn-primary">Update</button>
						</form>
						<%
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div style="margin-top: 100px;">
		<%@include file="/all_component/footer.jsp"%>
	</div>
</body>
</html>