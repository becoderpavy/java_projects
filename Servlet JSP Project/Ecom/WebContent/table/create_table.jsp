<%@page import="com.conn.*"%>
<%@page import="java.sql.*"%>

<%
try {

	String sq = "create table user(name varchar(100),email varchar(100)primary key,mobileNumber bigint,securityQuestion varchar(200),answer varchar(200),password varchar(100),address varchar(500),city varchar(100),state varchar(100),country varchar(100))";
	String sq2="create table product(id int,name varchar(500),category varchar(200),price int,active varchar(10))";
	String sq3="create table cart(email varchar(100),product_id int,quantity int,price int,total int,address varchar(500),city varchar(100),state varchar(100),country varchar(100),mobileNumber bigint,orderDate varchar(100),delivaryDate varchar(100),paymentMethod varchar(100),transactionId varchar(100),status varchar(10))";
	
	Connection conn = ConnectionProvider.getConnection();
	PreparedStatement ps=conn.prepareStatement(sq);
	PreparedStatement ps2=conn.prepareStatement(sq2);
	PreparedStatement ps3=conn.prepareStatement(sq3);
	//ps.execute();
	//ps2.execute();
	ps3.execute();
	System.out.println("Table created");

} catch (Exception e) {
	e.printStackTrace();
}
%>