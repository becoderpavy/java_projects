<%@page import="com.DAO.OrderDAOImpl"%>
<%@page import="com.DB.DBConnect"%>

<%
	String st = request.getParameter("st");
	if (st != null) {
		int id = Integer.parseInt(request.getParameter("id"));
		OrderDAOImpl dao2 = new OrderDAOImpl(DBConnect.getConn());
		boolean f = dao2.updateStatus(st, id);
		if (f) {
			session.setAttribute("succMsg", "order status updated");
			response.sendRedirect("order.jsp");
		}
	}
	%>