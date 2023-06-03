package com.transport.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.transport.conn.DbConnect;
import com.transport.dao.VehicleDAO;
import com.transport.entites.BookVehicle;

@WebServlet("/bookVh")
public class BookVechicleServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String kms = req.getParameter("kms");
			String amount = req.getParameter("amount");
			String date = req.getParameter("date");
			String vehicleNumber = req.getParameter("vehicleNumber");
			String userName = req.getParameter("userName");
			String location = req.getParameter("location");

			BookVehicle bv = new BookVehicle(kms, amount, date, vehicleNumber, userName, location);

			VehicleDAO dao = new VehicleDAO(DbConnect.getConnection());
			boolean f = dao.bookVehicle(bv);
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Vehicle Booked Success");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}
			resp.sendRedirect("user/service.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
