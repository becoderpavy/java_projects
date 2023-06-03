package com.Servlet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.PostDAO;
import com.Db.DBConnect;
import com.entity.Note;

@WebServlet("/AddNotesServlet")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 100, 
		maxFileSize = 1024 * 1024 * 100, 
		maxRequestSize = 1024 * 1024 * 100 
)
public class AddNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int uid = Integer.parseInt(request.getParameter("uid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm");
		LocalDateTime localDateTime=LocalDateTime.now();
		String time=formatter.format(localDateTime);

		Part p = request.getPart("file");
		String fileName = "";

		if (p.getSubmittedFileName().isEmpty()) {
			fileName = "NA";
		} else {
			fileName = p.getSubmittedFileName();
		}

		PostDAO dao = new PostDAO(DBConnect.getConn());
		boolean f = dao.AddNotes(title, content, uid, time,fileName);
		HttpSession session = request.getSession();

		if (f) {

			if (!p.getSubmittedFileName().isEmpty()) {
				String path = getServletContext().getRealPath("") + "note";
				File file = new File(path);
				p.write(path + File.separator + fileName);
			}

			session.setAttribute("updateMsg", "Notes Added Sucessfully");
			response.sendRedirect("addNotes.jsp");

		} else {
			session.setAttribute("errorMsg", "Something wrong on server.");
			response.sendRedirect("addNotes.jsp");
		}

	}

}
