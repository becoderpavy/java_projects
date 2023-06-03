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

	<%
	String errorMsg = (String) session.getAttribute("ErrorMsg");
	if (errorMsg != null) {
	%>
	<div class="alert alert-danger text-center" role="alert"><%=errorMsg%></div>
	<%
	session.removeAttribute("ErrorMsg");
	}
	%>

	<%
	String SucessMsg = (String) session.getAttribute("SucessMsg");
	if (SucessMsg != null) {
	%>
	<div class="alert alert-warning text-center" role="alert">
		<i class="fas fa-clock "></i>
		<%=SucessMsg%></div>
	<%
	session.removeAttribute("SucessMsg");
	}
	%>

	<div class="container-fluid">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<form>

							<div class="form-group">
								<label for="exampleInputEmail1">Name*</label> <input name="name"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address*</label> <input
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Phone*</label> <input
									name="phno" type="number" class="form-control"
									id="exampleInputPassword1">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password*</label> <input
									name="password" type="password" class="form-control"
									id="exampleInputPassword1" required="required">
							</div>
							<div class="form-group form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Check me out</label>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
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