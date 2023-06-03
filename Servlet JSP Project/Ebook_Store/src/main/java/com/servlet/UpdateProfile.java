package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProfessorDao;
import com.db.DbConnect;
import com.entity.Professor;

@WebServlet("/updateprofessor")
public class UpdateProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String na = req.getParameter("na");
			String de = req.getParameter("de");
			String cn = req.getParameter("cn");
			String em = req.getParameter("em");
			String ps = req.getParameter("ps");

			Professor p = new Professor(id, na, de, cn, em, ps);

			ProfessorDao dao = new ProfessorDao(DbConnect.getConn());
			
			HttpSession session = req.getSession();
			boolean f2 = dao.checkPassword(id, ps);
			
			if (f2) {
				boolean f = dao.updateProfessor(p);
				if (f) {
					session.setAttribute("succMsg", "Your Profile Update Sucessfully");
					resp.sendRedirect("view_profile.jsp");
				} else {
					session.setAttribute("errorMsg", "Something Went Wrong on Server");
					resp.sendRedirect("view_profile.jsp");
				}
			} else {
				session.setAttribute("errorMsg", "Your Password is incorrect");
				resp.sendRedirect("view_profile.jsp");
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
