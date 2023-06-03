<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h5 class="text-center text-success">Add Adress</h5>
						<%
						String errorMsg = (String) session.getAttribute("errorMsg");
						if (errorMsg != null) {
						%>
						<p class="text-danger text-center"><%=errorMsg%></p>
						<%
						session.removeAttribute("errorMsg");
						}
						%>

						<%
						String SucessMsg = (String) session.getAttribute("sucessMsg");
						if (SucessMsg != null) {
						%>
						<p class="text-success text-center">

							<%=SucessMsg%></p>
							<%
							session.removeAttribute("sucessMsg");
							}
							%>
						
						<form action="addAdress" method="post">
							<div class="form-row">
								<div class="form-group col-md-6">

									<%
									if (user == null) {
										response.sendRedirect("login.jsp");
									} else {
									%>
									<input type="hidden" value="<%=user.getId()%>" name="id">
									<%
									}
									%>


									<label for="inputAddress">Address</label> <input type="text"
										class="form-control" id="inputAddress"
										placeholder="Local, Area, street" name="address" value="<%=user.getAdress()%>">
								</div>
								<div class="form-group col-md-6">
									<label for="inputAddress2">Landmark</label> <input type="text"
										class="form-control" id="inputAddress2"
										placeholder="Apartment, studio, or floor" name="landmark" value="<%=user.getLandmark()%>">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputCity">City</label> <input type="text"
										class="form-control" id="inputCity" name="city" value="<%=user.getCity()%>">
								</div>
								<div class="form-group col-md-3">
									<label for="inputState">State</label> <input type="text"
										name="state" class="form-control" name="state" value="<%=user.getState()%>">
								</div>
								<div class="form-group col-md-3">
									<label for="inputZip">Zip</label> <input type="text"
										class="form-control" id="inputZip" name="pin" value="<%=user.getZip()%>">
								</div>
							</div>

							<div class="container text-center text-white">
								<button type="submit" class="btn btn-warning">Add
									Adress</button>
							</div>
						</form>
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