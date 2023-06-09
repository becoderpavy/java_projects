<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="component/all_css.jsp"%>
</head>
<body style="background-color: #f7f7f7;">

	<%@include file="component/navbar.jsp"%>
	<div class="continer-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Login Page</h5>
							<%
							String errorMsg = (String) session.getAttribute("Login-error");
							if (errorMsg != null) {
							%>
							<p class="text-danger"><%=errorMsg%></p>
							<%
							session.removeAttribute("Login-error");
							}
							%>
							<%
							String lgMsg = (String) session.getAttribute("logoutMsg");
							if (lgMsg != null) {
							%>

							<p class="text-success text-center"><%=lgMsg%></p>

							<%
							session.removeAttribute("logoutMsg");
							}
							%>
						</div>
						<form action="loginServlet" method="post">

							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="uemail">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									required="required" type="password" class="form-control"
									id="exampleInputPassword1" name="upassword">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
						<div class="text-center">
							<a href="forgotpassword.jsp">Forgot Password</a>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>