<%@page import="java.time.LocalDate"%>
<%@page import="com.entity.CartDtls"%>
<%@page import="com.entity.OrderDtls"%>
<%@page import="com.DAO.OrderDAOImpl"%>
<%@page import="com.entity.UserDtls"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.entity.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.CartDAOImpl"%>

<%
String username1 = request.getParameter("username");
String email1 = request.getParameter("email");
String phno1 = request.getParameter("phno");
String address1 = request.getParameter("address");

UserDtls u = (UserDtls) session.getAttribute("userobj");
CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());

List<CartDtls> clist = dao.getCartPetsByUser(u.getId());
OrderDAOImpl dao2 = new OrderDAOImpl(DBConnect.getConn());
OrderDtls o = null;

ArrayList<OrderDtls> orderList = new ArrayList<OrderDtls>();

Random r = new Random();
for (CartDtls c : clist) {
	o = new OrderDtls();
	o.setUserId(u.getId());
	o.setShopId(c.getShopId());
	o.setOrderId("ORD-00" + r.nextInt(1000));
	o.setUserName(username1);
	o.setEmail(email1);
	o.setAddress(address1);
	o.setPhno(phno1);
	o.setCategorie(c.getCategorie());
	o.setPetName(c.getPetsName());
	o.setPrice(c.getPrice());
	o.setPaymentType("Online Payment");
	o.setStatus("Order Processing");
	o.setDate(LocalDate.now().toString());
	orderList.add(o);
}

boolean f = dao2.addOrder(orderList);

if (f) {
	response.sendRedirect("order_success.jsp");
} else {
	session.setAttribute("failedMsg", "Your Order Failed");
	response.sendRedirect("checkout.jsp");
}
%>