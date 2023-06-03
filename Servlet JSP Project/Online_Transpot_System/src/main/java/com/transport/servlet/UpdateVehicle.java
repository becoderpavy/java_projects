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
import com.transport.entites.Vehicle;

@WebServlet("/updateVehicle")
public class UpdateVehicle extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String vechicleNumber = req.getParameter("vechicleNumber");
			String vehicleType = req.getParameter("vehicleType");
			String location = req.getParameter("location");
			String availability = req.getParameter("availability");
			String insuranceStatus = req.getParameter("insuranceStatus");
			String description = req.getParameter("description");
			String ownerName = req.getParameter("ownerName");
			String contactNo = req.getParameter("contactNo");
			int id = Integer.parseInt(req.getParameter("id"));

			Vehicle v = new Vehicle(id, vechicleNumber, vehicleType, location, availability, insuranceStatus,
					description, ownerName, contactNo);

			VehicleDAO dao = new VehicleDAO(DbConnect.getConnection());
			boolean f = dao.updateVehicle(v);
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Vehicle Update Success");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}
			resp.sendRedirect("manager/view_truck.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
