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
import com.DB.DBConnect;
import com.entity.PetDtls;

@WebServlet("/update_pet")
@MultipartConfig
public class UpdatePetServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int sid = Integer.parseInt(req.getParameter("sid"));
			int pid = Integer.parseInt(req.getParameter("pid"));

			String ca = req.getParameter("ca");
			String pa = req.getParameter("pa");
			String de = req.getParameter("de");
			Double pr = Double.parseDouble(req.getParameter("pr"));
			int sto = Integer.parseInt(req.getParameter("st"));
			

			PetDAOImpl dao = new PetDAOImpl(DBConnect.getConn());

			String st = req.getParameter("sta");

			PetDtls pe = new PetDtls(pid, sid, ca, pa, de, pr, sto, "", st);
			HttpSession session = req.getSession();

			boolean f = dao.updatePetsDetails(pe);

			if (f) {
				session.setAttribute("succMsg", "Pets Details Update Successfully..");
				resp.sendRedirect("shop/view_pets.jsp");

			} else {
				// System.out.println("Something wrong on server..");
				session.setAttribute("failedMsg", "Something wrong on server..");
				resp.sendRedirect("shop/view_pets.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
