package com.user.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.OrderDAOImpl;
import com.DB.DBConnect;
import com.entity.CartDtls;
import com.entity.OrderDtls;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			HttpSession session = req.getSession();

			int id = Integer.parseInt(req.getParameter("id"));

			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String totalPrice = req.getParameter("totalPrice");
			String paymentType = req.getParameter("payment");

			String fullAdd = address + "," + landmark + "," + city + "," + state + "," + pincode;

			// System.out.println(id + "," + name + " " + email + " " + phno + " " + fullAdd
			// + " " + paymentType);

			if ("COD".equals(paymentType)) {

				CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());

				List<CartDtls> clist = dao.getCartPetsByUser(id);

				/*
				 * for (CartDtls c : clist) { System.out.println(c); }
				 */

				if (clist.isEmpty()) {
					session.setAttribute("failedMsg", "Add Item");
					resp.sendRedirect("checkout.jsp");
				} else {

					OrderDAOImpl dao2 = new OrderDAOImpl(DBConnect.getConn());
					OrderDtls o = null;

					ArrayList<OrderDtls> orderList = new ArrayList<OrderDtls>();

					Random r = new Random();
					for (CartDtls c : clist) {
						o = new OrderDtls();
						o.setUserId(id);
						o.setShopId(c.getShopId());
						o.setOrderId("ORD-00" + r.nextInt(1000));
						o.setUserName(name);
						o.setEmail(email);
						o.setAddress(fullAdd);
						o.setPhno(phno);
						o.setCategorie(c.getCategorie());
						o.setPetName(c.getPetsName());
						o.setPrice(c.getPrice());
						o.setPaymentType(paymentType);
						o.setStatus("Order Processing");
						o.setDate(LocalDate.now().toString());
						orderList.add(o);
					}

					if ("noselect".equals(paymentType)) {
						session.setAttribute("failedMsg", "Choose Payment Method");
						resp.sendRedirect("checkout.jsp");
					} else {
						boolean f = dao2.addOrder(orderList);

						if (f) {
							resp.sendRedirect("order_success.jsp");
						} else {
							session.setAttribute("failedMsg", "Your Order Failed");
							resp.sendRedirect("checkout.jsp");
						}
					}
				}
			} else if ("noselect".equals(paymentType)) {
				session.setAttribute("failedMsg", "Choose Payment Method");
				resp.sendRedirect("checkout.jsp");
			}
			else {
				resp.sendRedirect("cardpayment.jsp?un=" + name + "&&em=" + email + "&&ph=" + phno + "&&ad=" + fullAdd
						+ "&&ta=" + totalPrice);
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

}
