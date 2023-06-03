package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PostDAO;
import com.Db.DBConnect;
import com.entity.Note;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int uid = Integer.parseInt(request.getParameter("uid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		PostDAO dao = new PostDAO(DBConnect.getConn());
		boolean f = dao.AddNotes(title, content, uid);
		HttpSession session = request.getSession();
		if (f) {
			session.setAttribute("updateMsg", "Notes Added Sucessfully");
			response.sendRedirect("addNotes.jsp");

		} else {
			session.setAttribute("errorMsg", "Something wrong on server.");
			response.sendRedirect("addNotes.jsp");
		}

	}

}
