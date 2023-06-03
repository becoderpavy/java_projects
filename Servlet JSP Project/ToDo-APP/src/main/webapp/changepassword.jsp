<%@page import="com.DB.DBConnect"%>

<%@page import="com.DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all_css.jsp"%>

</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<div class="continer-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Change Password</h5>
						</div>

						<%
						String em = request.getParameter("em");
						%>

						<form action="changepassword.jsp" method="post"
							oninput='cpass.setCustomValidity(cpass.value != pass.value ? "Passwords do not match." : "")'>

							<div class="form-group">
								<label>Enter New Password</label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="pass">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Enter Confirm
									Password</label> <input required="required" type="text"
									class="form-control" id="exampleInputPassword1" name="cpass">
							</div>



							<input type="hidden" value="<%=em%>" name="email">

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Change
								Password</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<%
	String pass = request.getParameter("pass");
	String email = request.getParameter("email");

	if (pass != null && email != null) {
		UserDAO dao = new UserDAO(DBConnect.getConn());
		if (dao.changePassword(pass, email)) {
			session.setAttribute("logoutMsg", "Password Change Successfully");
			response.sendRedirect("forgotpassword.jsp");
		} else {
			session.setAttribute("Login-error", "Something wrong on server");
			response.sendRedirect("forgotpassword.jsp");
		}
	}
	%>
</body>
</html>