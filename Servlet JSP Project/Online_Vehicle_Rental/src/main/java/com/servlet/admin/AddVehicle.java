package com.servlet.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.VehicleDao;
import com.db.DBConnect;
import com.entites.Vehicle;

@WebServlet("/addVehicle")
@MultipartConfig
public class AddVehicle extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String vehicleNumber = req.getParameter("vehicleNumber");
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		String availability = req.getParameter("availability");
		Double perDay = Double.parseDouble(req.getParameter("perDay"));
		String insuranceStatus = req.getParameter("insuranceStatus");
		String description = req.getParameter("description");
		String ownerName = req.getParameter("ownerName");
		String contactNo = req.getParameter("contactNo");

		Part p = req.getPart("img");
		String image = p.getSubmittedFileName();

		Vehicle v = new Vehicle(title, vehicleNumber, categoryId, availability, perDay, insuranceStatus, description,
				ownerName, contactNo, image);

		VehicleDao dao = new VehicleDao(DBConnect.getConnection());

		HttpSession session = req.getSession();

		if (dao.checkVehicleNumber(vehicleNumber)) {
			session.setAttribute("errorMsg", "Already Vehicle Number Registered");
			resp.sendRedirect("admin/add_vehicle.jsp");
		}

		else {

			if (dao.createVehicle(v)) {

				String path = req.getServletContext().getRealPath("") + "img/vehicle_img" + File.separator + image;
				//System.out.println(path);

				File file = new File(path);
				p.write(path);

				session.setAttribute("succMsg", "Added successfully");
				resp.sendRedirect("admin/add_vehicle.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/add_vehicle.jsp");
			}

		}

	}

}
