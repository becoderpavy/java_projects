package com.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PetDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete_pet")
public class DeletePetServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int sid = Integer.parseInt(req.getParameter("sid"));
			int pid = Integer.parseInt(req.getParameter("pid"));
			
			PetDAOImpl dao=new PetDAOImpl(DBConnect.getConn());
			HttpSession session = req.getSession();
			boolean f=dao.deletePet(pid, sid);
			if (f) {
				session.setAttribute("succMsg", "Pets Details Delete Successfully..");
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
