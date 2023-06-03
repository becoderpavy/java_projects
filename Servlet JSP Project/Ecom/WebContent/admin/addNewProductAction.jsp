<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="com.conn.*"%>
<%
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String category = request.getParameter("category");
			String price = request.getParameter("price");
			String active = request.getParameter("active");

			try{
				Connection conn=ConnectionProvider.getConnection();
				PreparedStatement ps=conn.prepareStatement("insert into product values(?,?,?,?,?)");
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, category);
				ps.setString(4, price);
				ps.setString(5, active);
				ps.execute();
				response.sendRedirect("addNewProduct.jsp?msg=done");
				
			}catch(Exception e)
			{
				response.sendRedirect("addNewProduct.jsp?msg=wrong");
				e.printStackTrace();
			}
			
			%>

