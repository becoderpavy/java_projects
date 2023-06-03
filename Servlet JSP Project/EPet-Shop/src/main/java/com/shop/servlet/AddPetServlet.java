package com.shop.servlet;

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

import com.DAO.PetDAOImpl;
import com.DAO.ShopDAOImpl;
import com.DB.DBConnect;
import com.entity.PetDtls;

@WebServlet("/add_pet")
@MultipartConfig
public class AddPetServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int si = Integer.parseInt(req.getParameter("si"));
			String ca = req.getParameter("ca");
			String pa = req.getParameter("pa");
			String de = req.getParameter("de");
			Double pr = Double.parseDouble(req.getParameter("pr"));
			int sto = Integer.parseInt(req.getParameter("st"));
			Part p = req.getPart("img");
			String im="";
			if (p == null) {
				 im = "pet.png";
			} else {
				 im = p.getSubmittedFileName();
			}

			String st = "Active";

			PetDtls pe = new PetDtls(si, ca, pa, de, pr, sto, im, st);
			HttpSession session = req.getSession();

			PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());

			boolean f = dao.addPets(pe);

			if (f) {
				String path = req.getServletContext().getRealPath("") + "pet_img" + File.separator + im;
				//System.out.println(path);
				File file = new File(path);
				p.write(path);
				session.setAttribute("succMsg", "Pets Added Successfully..");
				resp.sendRedirect("shop/add_pet.jsp");

			} else {
				// System.out.println("Something wrong on server..");
				session.setAttribute("failedMsg", "Something wrong on server..");
				resp.sendRedirect("shop/add_pet.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
