package com.servlet;

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

import com.conn.DBConnect;
import com.dao.CandidateDAO;
import com.entity.Candidates;

@WebServlet("/applyJob")
@MultipartConfig
public class JobApply extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String name = req.getParameter("name");
			String email = req.getParameter("email");
			int userId = Integer.parseInt(req.getParameter("userId"));
			int jobId = Integer.parseInt(req.getParameter("jobId"));
			Part p = req.getPart("file");
			String resume = p.getSubmittedFileName();

			Candidates c = new Candidates(name, email, userId, jobId, "Not Schedule", resume);
			CandidateDAO dao = new CandidateDAO(DBConnect.getConn());

			HttpSession session = req.getSession();
			if (dao.saveCandidates(c)) {
				String path = getServletContext().getRealPath("") + "resume";
				System.out.println(path);
				File file = new File(path);
				p.write(path + File.separator + resume);
				session.setAttribute("succMsg", "Job Apply Sucessfully");
				resp.sendRedirect("one_view.jsp?id=" + jobId);

			} else {
				session.setAttribute("errorMsg", "Something error in server");
				resp.sendRedirect("one_view.jsp?id=" + jobId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
