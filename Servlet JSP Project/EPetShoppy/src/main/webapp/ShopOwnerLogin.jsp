<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.*" %>
    <%!
	String un, up;
%>
    
 <%
 	un=request.getParameter("mbno");
 	up=request.getParameter("pwd");
 	
 	try
	{
	
 	Class.forName("org.postgresql.Driver");
 	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectdb","postgres","postgres");
 	PreparedStatement st=con.prepareStatement("select count(*) from  shopowner_reg where mbno=? and pwd=?");
 	st.setString(1, un);
 	st.setString(2, up);
 	
 	ResultSet rs=st.executeQuery();
	if(rs.next())
	{
		int x = rs.getInt(1);
		if(x==1)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			//out.println("Enter Valid Username or Password");
			//response.sendRedirect("login.jsp ");
%>		
			<script>
				if(confirm("Invalid Username or Password"))
					{
						location="ShopOwner.html";
					}
				else{
						location="ShopOwner.html";
				}
			</script>
<%
		}
	}
	}
 	catch(Exception e)
 	{
 		out.println(e);
 	}
 
 
 %>  
