package com.Servlet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.QueryDAO;
import com.Db.DBConnect;

@WebServlet("/addQuries")
@MultipartConfig
public class AddQueries extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String query = request.getParameter("query");
		String categories = request.getParameter("categories");
		String postDate = LocalDate.now().toString();
		String descr = request.getParameter("desc");
		Part part = request.getPart("img");
		String filename = part.getSubmittedFileName();

		QueryDAO dao = new QueryDAO(DBConnect.getConn());

		HttpSession session = request.getSession();
		if (username == null) {
			response.sendRedirect("login.jsp");

		} else {
			if ("Select".equals(categories)) {

				session.setAttribute("failedMsg", "Select Categories");
				response.sendRedirect("index.jsp");

			} else {
				boolean f = dao.AddQueries(query, categories, username, postDate, descr, filename);

				if (filename.length() != 0) {
					String path = getServletContext().getRealPath("") + "img";
					System.out.println(path);
					File file = new File(path);
					part.write(path + File.separator + filename);
				}

				session.setAttribute("qu", "Queries Post Sucessfully..");
				response.sendRedirect("index.jsp");
			}
		}

	}

}
