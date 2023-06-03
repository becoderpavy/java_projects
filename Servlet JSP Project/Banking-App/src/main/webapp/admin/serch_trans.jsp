<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Search Transaction</title>
<%@include file="allcss.jsp"%>
</head>
<body>
	<%@include file="main_navbar.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<%@include file="left-navbar.jsp"%>
			<div class="col-md-10 offset-md-2">
				<h1 class="text-center">Search Transaction</h1>


				<div class="col-md-5 offset-md-4 mt-5">
					<form class="form-inline">
						<div class="form-group mx-sm-3 mb-2">
							<input type="password" class="form-control" id="inputPassword2"
								placeholder="Enter Account No">
						</div>
						<button type="submit" class="btn btn-primary mb-2">Search</button>
					</form>
				</div>

<hr>
				<table class="table table-striped mt-5">
					<thead class="bg-primary text-light">
						<tr>
							<th scope="col">Account No</th>
							<th scope="col">Date</th>
							<th scope="col">Type</th>
							<th scope="col">Amount</th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
							
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Jacob</td>
							<td>Thornton</td>
							<td>@fat</td>
							
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>Larry</td>
							<td>the Bird</td>
							<td>@twitter</td>							
						</tr>
					</tbody>
				</table>


			</div>
		</div>
	</div>
</body>
</html>