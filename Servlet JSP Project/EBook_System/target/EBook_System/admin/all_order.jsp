<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss_file.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<h3 class="text-center mt-1">Hello, Admin</h3>

	<div class="container-fluid mt-3">
		<table class="table">
			<thead class="thead-dark">
				<tr>
				    <th scope="col">Order id</th>
					<th scope="col">Product Name</th>
					<th scope="col">Customer Name</th>
					<th scope="col">Address</th>
					<th scope="col">Payment Type</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
			</tbody>
		</table>

	</div>



</body>
</html>