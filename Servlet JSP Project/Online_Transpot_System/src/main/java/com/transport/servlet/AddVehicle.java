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

@WebServlet("/addVehicle")
public class AddVehicle extends HttpServlet {

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

			Vehicle v = new Vehicle(vechicleNumber, vehicleType, location, availability, insuranceStatus, description,
					ownerName, contactNo);

			VehicleDAO dao = new VehicleDAO(DbConnect.getConnection());
			boolean f = dao.createVehicle(v);
			HttpSession session = req.getSession();
			
			if (f) {
				session.setAttribute("succMsg", "Vehicle Added Success");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}
			resp.sendRedirect("manager/add_truck.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
