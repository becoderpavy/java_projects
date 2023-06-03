package com.admin.servlet;

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

@WebServlet("/notesEdit")
@MultipartConfig
public class NotesEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer noteid = Integer.parseInt(request.getParameter("noteid"));
			String Title = request.getParameter("title");
			String Content = request.getParameter("content");

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm");
			LocalDateTime localDateTime = LocalDateTime.now();
			String time = formatter.format(localDateTime);

			Part p = request.getPart("file");
			String fileName = "";

			PostDAO dao = new PostDAO(DBConnect.getConn());

			if (p.getSubmittedFileName().isEmpty()) {
				Note n = dao.getDataById(noteid);
				fileName = n.getFileName();
			} else {
				fileName = p.getSubmittedFileName();
			}

			boolean f = dao.PostUpdate(noteid, Title, Content, time, fileName);
			HttpSession session = request.getSession();
			if (f) {
				if (!p.getSubmittedFileName().isEmpty()) {
					String path = getServletContext().getRealPath("") + "note";
					File file = new File(path);
					p.write(path + File.separator + fileName);
				}
				session.setAttribute("updateMsg", "Notes Update Sucessfully");
				response.sendRedirect("admin/view_all_notes.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				response.sendRedirect("admin/view_all_notes.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
