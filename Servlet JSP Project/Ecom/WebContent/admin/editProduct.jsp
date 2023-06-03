<%@include file="adminHeader.jsp"%>
<%@include file="../footer.jsp"%>

<html>
<head>
<link rel="stylesheet" href="../css/addNewProduct-style.css">
<title>Add New Product</title>
<style>
.back {
	color: white;
	margin-left: 2.5%
}
</style>
</head>
<body>
	<h2>
		<a class="back" href="allProductEditProduct.jsp"><i
			class='fas fa-arrow-circle-left'> Back</i></a>
	</h2>
	<%
	Integer id = Integer.parseInt(request.getParameter("msg"));

	try {

		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from product where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
	%>
	<form action="editProductAction.jsp" method="post">
		<input type="hidden" value="<%=rs.getInt(1)%>" name="id">
		<div class="left-div">
			<h3>Enter Name</h3>
			<input class="input-style" type="text" value="<%=rs.getString(2)%>"
				name="name" required="required">
			<hr>
		</div>

		<div class="right-div">
			<h3>Enter Category</h3>
			<input class="input-style" type="text" value="<%=rs.getString(3)%>"
				name="category" required="required">
			<hr>
		</div>

		<div class="left-div">
			<h3>Enter Price</h3>
			<input class="input-style" type="text" value="<%=rs.getString(4)%>"
				name="price" required="required">
			<hr>
		</div>

		<div class="right-div">
			<h3>Active</h3>
			<select class="input-style" name="active">
				<option value="yes">yes</option>
				<option value="no">No</option>
			</select>
			<hr>
		</div>
		<button class="button">
			Save<i class='far fa-arrow-alt-circle-right'></i>
		</button>
	</form>
	<%
	}
	} catch (Exception e) {
	e.printStackTrace();

	}
	%>






</body>
<br>
<br>
<br>
</body>
</html>