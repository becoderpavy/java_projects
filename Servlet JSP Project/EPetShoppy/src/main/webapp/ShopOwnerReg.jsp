<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import="java.sql.*" %>
<%!
	String fname, lname, shopname, email, mbno, address, city, state, pwd;
%>

<%
	fname=request.getParameter("txtfname");
	lname=request.getParameter("txtlname");
	shopname=request.getParameter("txtsname");
	email=request.getParameter("emailid");
	mbno=request.getParameter("txtmno");
	address=request.getParameter("address");
	city=request.getParameter("city");
	state=request.getParameter("state");
	pwd=request.getParameter("pwd");
	
	try
	{
	
	Class.forName("org.postgresql.Driver");
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectdb","postgres","postgres");
	PreparedStatement ps=con.prepareStatement("insert into ShopOwner_Reg values(?,?,?,?,?,?,?,?,?)");
	ps.setString(1, fname);
	ps.setString(2,lname);
	ps.setString(3,shopname);
	ps.setString(4,email);
	ps.setString(5,mbno);
	ps.setString(6,address);
	ps.setString(7,city);
	ps.setString(8,state);
	ps.setString(9,pwd);
	
	int x=ps.executeUpdate();
	if(x>0){
		response.sendRedirect("login.jsp");
	}
	else{
		out.println("Error in execution");
	}
	
	}
	catch(Exception e)
	{
		out.println(e);
	}
	
	
	
	
%>

</body>
</html>