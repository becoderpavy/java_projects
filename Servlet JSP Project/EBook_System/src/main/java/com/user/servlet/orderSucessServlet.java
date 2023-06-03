package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CartDAOImpl;
import com.DAO.OrderDAOImpl;
import com.conn.ConnectionProvider;
import com.entity.cart;
import com.entity.orderDtls;

@WebServlet("/orderSucessServlet")
public class orderSucessServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int uid=Integer.parseInt(req.getParameter("uid"));
			
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String phone=req.getParameter("phone");
			String adress=req.getParameter("adress");
			String landmark=req.getParameter("landmark");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String pin=req.getParameter("pin");
			String payment=req.getParameter("payment");
			
			
			String fullAddress=adress +","+landmark+","+ city+","+ state+","+ pin;
			
			CartDAOImpl cdao=new CartDAOImpl(ConnectionProvider.getConnection());
			List<cart> crt=cdao.getCartDetails(uid);
			
			OrderDAOImpl odao=new OrderDAOImpl(ConnectionProvider.getConnection());
			int i=odao.getTotalOrderNo();
			
			orderDtls order=null;
			List<orderDtls> list=new ArrayList<orderDtls>();
			
			for(cart c:crt)
			{					
				order=new orderDtls();
				String orderid="BOOK-ORD-00"+i;
				
				order.setOrderId(orderid);
				order.setUserName(name);
				order.setEmail(email);
				order.setAddress(fullAddress);
				order.setPhoneNo(phone);
				order.setBookName(c.getBookName());
				order.setBookAuthor(c.getAuthor());
				order.setPrice(c.getPrice());
				order.setPaymentType(payment);
				i++;
				list.add(order);
			}
			
			OrderDAOImpl dao=new OrderDAOImpl(ConnectionProvider.getConnection());
			boolean f=dao.orderSave(list);
			
			if(f)
			{
				resp.sendRedirect("order_sucess.jsp");
			}else {
				resp.sendRedirect("index.jsp");
			}
			
			
		} catch (Exception e) {
		e.printStackTrace();	
		}
	}

}
