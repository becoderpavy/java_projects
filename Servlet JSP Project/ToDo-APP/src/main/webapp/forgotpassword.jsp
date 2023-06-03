
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
	"
	<div class="continer-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Forgot Password</h5>
						</div>

						<%
						String errorMsg = (String) session.getAttribute("Login-error");
						if (errorMsg != null) {
						%>
						<p class="text-danger text-center"><%=errorMsg%></p>
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

						<form action="forgotpassword.jsp" method="post">

							<div class="form-group">
								<label>Enter Email</label> <input type="email" required
									class="form-control" name="email">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Enter Mobile Number</label> <input
									required type="number" class="form-control" name="mobno">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Submit</button>
						</form>

					</div>

				</div>
			</div>
		</div>
	</div>


	<%
	String em = request.getParameter("email");
	String mobno = request.getParameter("mobno");

	if (em != null && mobno != null) {

		UserDAO dao = new UserDAO(DBConnect.getConn());
		boolean f = dao.checkEmailAndMobNo(em, mobno);
		if (f) {
			response.sendRedirect("changepassword.jsp?em=" + em);
		} else {
			session.setAttribute("Login-error", "invalid email mobno");
			response.sendRedirect("forgotpassword.jsp");
		}
	}
	%>

</body>
</html>