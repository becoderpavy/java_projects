<%@page import="java.sql.*"%>
<%@page import="com.conn.*"%>
<%@include file="header.jsp"%>
<%@include file="footer.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div style="color: white; text-align: center; font-size: 30px;">
		Home <i class="fa fa-institution"></i>
	</div>
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
			int z = 0;
			try {
				String search = request.getParameter("search");
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement ps = conn
				.prepareStatement("select * from product where name like ? or category like ? and active=?");
				ps.setString(1, "%" + search + "%");
				ps.setString(2, "%" + search + "%");
				ps.setString(3, "yes");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					z = 1;
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
	<%
	if (z == 0) {
	%>
	<h1 style="color: white; text-align: center;">Nothing to show</h1>
	<%
	}
	%>


	<br>
	<br>
	<br>
	<div class="footer">
		<p>All right reserved by BTech Days</p>
	</div>

</body>
</html>