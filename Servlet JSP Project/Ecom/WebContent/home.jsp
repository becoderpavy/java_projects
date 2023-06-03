
<%@page import="java.sql.*"%>
<%@page import="com.conn.*"%>
<%@include file="header.jsp"%>
<%@include file="footer.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
h3 {
	color: yellow;
	text-align: center;
}
</style>
</head>
<body>
	<div style="color: white; text-align: center; font-size: 30px;">
		Home <i class="fa fa-institution"></i>
	</div>

	<%
	String msg = request.getParameter("msg");
	if ("added".equals(msg)) {
	%>
	<h3 class="alert">Product added successfully!</h3>
	<%
	}

	if ("exist".equals(msg)) {
	%>
	<h3 class="alert">Product already exist in you cart! Quantity
		increased!</h3>
	<%
	}
	if ("invalid".equals(msg)) {
	%>
	<h3 class="alert">Password change successfully!</h3>
	<%
	}
	%>

	<table>
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Category</th>
				<th scope="col"><i class="fa fa-inr"></i> Price</th>
				<th scope="col">Add to cart <i class='fas fa-cart-plus'></i></th>
			</tr>
		</thead>
		<tbody>
			<%
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement ps = conn.prepareStatement("select * from product where active=?");
				ps.setString(1,"yes");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><i class="fa fa-inr"></i><%=rs.getString(4)%> </i></td>
				<td><a href="addToCartAction.jsp?id=<%=rs.getInt(1)%>">Add
						to cart <i class='fas fa-cart-plus'></i>
				</a></td>
			</tr>
			<%
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			%>


		</tbody>
	</table>
	<br>
	<br>
	<br>

</body>
</html>