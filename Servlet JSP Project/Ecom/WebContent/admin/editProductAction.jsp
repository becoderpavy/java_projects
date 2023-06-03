<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.conn.*"%>
<%
Integer id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String category = request.getParameter("category");
String price = request.getParameter("price");
String active = request.getParameter("active");

try {
	Connection conn = ConnectionProvider.getConnection();
	PreparedStatement ps = conn
	.prepareStatement("update product set name=?, category=?, price=? , active=? where id=?");
	ps.setString(1, name);
	ps.setString(2, category);
	ps.setString(3, price);
	ps.setString(4, active);
	ps.setInt(5, id);
	ps.executeUpdate();

	if (active.equals("no")) {
		 ps = conn.prepareStatement("delete from cart where product_id=? and address is NULL");
		ps.execute();
	}
	response.sendRedirect("allProductEditProduct.jsp?msg=done");

} catch (Exception e) {
	response.sendRedirect("allProductEditProduct.jsp?msg=wrong");
	e.printStackTrace();
}
%>