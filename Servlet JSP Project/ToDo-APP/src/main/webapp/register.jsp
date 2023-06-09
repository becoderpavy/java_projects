<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
<%@include file="component/all_css.jsp"%>

</head>
<body style="background-color: #f7f7f7;">
	<%@include file="component/navbar.jsp"%>
	<div class="continer-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Registration</h5>
							<%
							String regMsg = (String) session.getAttribute("reg-sucess");

							if (regMsg != null) {
							%>
							<p class="text-success"><%=regMsg%>

							</p>

							<%
							session.removeAttribute("reg-sucess");
							}
							%>
							<%
							String FailedMsg = (String) session.getAttribute("failed-msg");

							if (FailedMsg != null) {
							%>

							<p class="text-danger"><%=FailedMsg%></p>

							<%
							session.removeAttribute("failed-msg");
							}
							%>
						</div>


						<form action="UserServlet" method="post">
							<div class="form-group">
								<label>Enter Full Name</label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="fname">
							</div>
							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="uemail">
							</div>

							<div class="form-group">
								<label>Enter Mobile Number</label> <input type="number"
									required="required" class="form-control" name="mobno">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									required="required" type="password" class="form-control"
									id="exampleInputPassword1" name="upassword">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>