
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.conn.*" %>
<%

String email=request.getParameter("email");
String mobileNumber=request.getParameter("mobileNumber");
String securityQuestion=request.getParameter("securityQuestion");
String answer=request.getParameter("answer");
String newPassword=request.getParameter("newPassword");

int check=0;
try{
	Connection conn=ConnectionProvider.getConnection();
	PreparedStatement ps=conn.prepareStatement("select * from user where email=? and mobileNumber=? and securityQuestion=? and answer=?");
	ps.setString(1, email);
	ps.setString(2, mobileNumber);
	ps.setString(3, securityQuestion);
	ps.setString(4, answer);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		check=1;
	    PreparedStatement ps1=conn.prepareStatement("update user set password=? where email=?");
	    ps1.setString(1, newPassword);
	    ps1.setString(2, email);
	    ps1.executeUpdate();
	    response.sendRedirect("forgotPassword.jsp?msg=done");
	}
	if(check==0)
	{
		response.sendRedirect("forgotPassword.jsp?msg=invalid");
	}
	
	
}catch(Exception e)
{
	e.printStackTrace();	
}

%>