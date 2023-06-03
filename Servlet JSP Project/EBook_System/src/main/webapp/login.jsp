<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook: Login</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="all_component/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<form class="needs-validation" novalidate method="post"
							action="loginServlet">
							<h3 class="text-center">Login</h3>
							<%
							String msg = (String) session.getAttribute("errorMsg");
							if (msg != null) {
							%>
							<h5 class="text-center text-danger"><%=msg%></h5>
							<%
							}
							session.removeAttribute("errorMsg");
							%>
							<%
							String logoutMsg = (String) session.getAttribute("logoutMsg");
							if (logoutMsg != null) {
							%>
							<h5 class="text-center text-success"><%=logoutMsg%></h5>
							<%
							}
							session.removeAttribute("logoutMsg");
							%>
							
							<% String updateSucessMsg=(String)session.getAttribute("updateSucessMsg");
							userDtls userdtls=(userDtls)session.getAttribute("LoginUser");
							if(updateSucessMsg!=null && userdtls!=null)
							{%>
								<h5 class="text-center text-success"><%=updateSucessMsg %></h5>
							<%
							session.removeAttribute("updateSucessMsg");
							session.removeAttribute("LoginUser");
							
							}					
							%>
							
							<div class="form-group">
								<label for="uname">Email:</label> <input type="email"
									class="form-control" id="uname" placeholder="Enter Email"
									name="email" required>
								<div class="valid-feedback"></div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="pwd">Password:</label> <input type="password"
									class="form-control" id="pwd" placeholder="Enter password"
									name="password" required>
								<div class="valid-feedback"></div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
							<div class="text-center">
								<a class="" href="create_account.jsp">Create Account</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div style="margin-top: 60px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>