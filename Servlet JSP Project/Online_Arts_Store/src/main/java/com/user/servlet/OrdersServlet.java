package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ArtistDAO;
import com.dao.CartDAO;
import com.dao.OrdersDAO;
import com.entity.Artist;
import com.entity.Cart;
import com.entity.Orders;
import com.entity.Paintings;
import com.util.DBConnect;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String card = req.getParameter("type");
			String amt = req.getParameter("amt");
			int uid = Integer.parseInt(req.getParameter("uid"));

			if ("Debit card".equals(card)) {
				resp.sendRedirect("card_payment.jsp?amt=" + amt + "&&uid=" + uid);
			} else {
				CartDAO dao = new CartDAO(DBConnect.getConnection());
				ArtistDAO dao2 = new ArtistDAO(DBConnect.getConnection());

				List<Cart> list = dao.getCart(uid);

				Orders order = null;

				List<Orders> orderList = new ArrayList<Orders>();
				Random random = new Random();

				for (Cart c : list) {
					order = new Orders();
					order.setOrderId("ORD-" + random.nextInt(1000));
					order.setPaintId(c.getPid());
					order.setUserId(c.getUid());
					order.setQuantity(c.getQuantity());
					order.setTotalAmount(amt);
					order.setPaymentType("COD");

					Paintings p = dao2.getPaintById(c.getPid());
					order.setArt_id(p.getArt_id());

					orderList.add(order);
				}

				OrdersDAO dao3 = new OrdersDAO(DBConnect.getConnection());
				boolean f = dao3.addOrder(orderList);

				if (f) {
					resp.sendRedirect("order_sucess.jsp");
				} else {
					resp.sendRedirect("index.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
