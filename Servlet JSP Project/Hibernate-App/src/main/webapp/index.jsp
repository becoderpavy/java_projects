<%@page import="com.util.HibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<html>
<body>
	<%
	SessionFactory s = HibernateUtil.getSessionFactory();
	out.print(s);
	%>
	<h2>Hello World!</h2>
	<a href="app">Submit</a>
</body>



</html>
