<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.conn.*"%>

<%
String email = request.getParameter("email");
String password = request.getParameter("password");

if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
	request.setAttribute("email", email);
	response.sendRedirect("admin/adminHome.jsp");
} else {
	int z = 0;
	try {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where email=? and password=?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
				z = 1;
				session.setAttribute("email", email);
				response.sendRedirect("home.jsp");
		}
		if (z == 0) {
	response.sendRedirect("login.jsp?msg=notexist");
		}

	} catch (Exception e) {
		response.sendRedirect("login.jsp?msg=invalid");
		e.printStackTrace();
	}
}
%>