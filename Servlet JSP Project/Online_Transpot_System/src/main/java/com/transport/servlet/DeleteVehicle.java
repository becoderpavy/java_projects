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

@WebServlet("/deleteVehicle")
public class DeleteVehicle extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));

			VehicleDAO dao = new VehicleDAO(DbConnect.getConnection());
			boolean f = dao.deleteVehicle(id);
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Vehicle Delete Success");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}
			resp.sendRedirect("manager/view_truck.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
