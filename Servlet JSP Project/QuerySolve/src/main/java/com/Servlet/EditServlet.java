package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.entity.User;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int id = Integer.parseInt(request.getParameter("uid"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String cid = request.getParameter("cid");
			String category = request.getParameter("category");

			User u = new User(id, name, email, gender, cid, category);
			UserDAO dao = new UserDAO(DBConnect.getConn());
			boolean f = dao.UpdateProfile(u);
			HttpSession session = request.getSession();

			if (f) {

				session.removeAttribute("userobj");
				session.setAttribute("succMsg", "Your Profile Update Sucessfully..Again Login");
				response.sendRedirect("login.jsp");
			} else {
				session.setAttribute("failedMsg", "Something went wrong on server");
				response.sendRedirect("index.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
