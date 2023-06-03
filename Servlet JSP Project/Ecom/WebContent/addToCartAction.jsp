<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.conn.*"%>

<%
String email = (String) session.getAttribute("email");

int product_id = Integer.parseInt(request.getParameter("id"));
int quantity = 1;
int product_price = 0;
int product_total = 0;
int cart_total = 0;

int z = 0;

try {
	
	//retrive product price from product table
	Connection conn = ConnectionProvider.getConnection();
	PreparedStatement ps = conn.prepareStatement("select * from product where id=?");
	ps.setInt(1,product_id);
	ResultSet rs = ps.executeQuery();
	
	while (rs.next()) {
		product_price = rs.getInt(4);
		product_total = product_price;
	}

	
	//already exist product in database
	PreparedStatement ps2 = conn
	.prepareStatement("select * from cart where product_id=? and email=? and address is NULL");
	ps2.setInt(1, product_id);
	ps2.setString(2, email);
	ResultSet rs2 = ps.executeQuery();
	
	while (rs2.next()) {
		cart_total=rs2.getInt(5);
		cart_total=cart_total+product_total;
		quantity=rs.getInt(3);
		quantity=quantity+1;
		z=1;
	}
	
	// product already exist update quantity and price in database
	if(z==1)
	{
		PreparedStatement ps3=conn.prepareStatement("update cart set total=? ,quantity=? where product_id=? and email=? and address is NULL");
		ps3.setInt(1, cart_total);
		ps3.setInt(2, quantity);
		ps3.setInt(3, product_id);
		ps3.setString(4, email);
		ps3.execute();
		response.sendRedirect("home.jsp?msg=exist");
	}
	//product is not available in db ,, add product in cart
	if(z==0)
	{
		PreparedStatement ps4=conn.prepareStatement("insert into cart(email,product_id,quantity,price,total) values(?,?,?,?,?)");
		ps4.setString(1, email);
		ps4.setInt(2, product_id);
		ps4.setInt(3, quantity);
		ps4.setInt(4, product_price);
		ps4.setInt(5, product_total);
		ps4.execute();
		response.sendRedirect("home.jsp?msg=added");
	}

} catch (Exception e) {
	response.sendRedirect("home.jsp?msg=invalid");
	e.printStackTrace();
}
%>