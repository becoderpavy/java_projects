package com.orphans.servlet;

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

import com.dao.OrphansDAO;
import com.dao.PatientDAOImpl;
import com.db.DBConnect;
import com.entity.Patient;

@WebServlet("/addOrphans")
@MultipartConfig
public class AddOrphans extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int oid = Integer.parseInt(req.getParameter("oid"));
			String na = req.getParameter("na");
			String pr = req.getParameter("pr");
			String ad = req.getParameter("ad");
			String ca=req.getParameter("categories");
			
			Part p = req.getPart("img");
			String im = "";
			if (p == null) {
				im = "default.png";
			} else {
				im = p.getSubmittedFileName();
			}

			Part p2 = req.getPart("doc");
			String doc = "";
			if (p2 == null) {
				doc = "default.png";
			} else {
				doc = p2.getSubmittedFileName();
			}

			Double nm = Double.parseDouble(req.getParameter("nm"));
			Double rm = 0.00;
			String st = "Pending";

			Patient patient = new Patient(oid, na, pr, ad, im, doc, nm, rm, st,ca);

			OrphansDAO dao = new OrphansDAO(DBConnect.getConn());
			boolean f = dao.addPatient(patient);
			HttpSession session = req.getSession();

			if (f) {
				String imgpath = req.getServletContext().getRealPath("") + "orphans_img" + File.separator + im;
				//System.out.println(imgpath);
				File f1 = new File(imgpath);

				String docpath = req.getServletContext().getRealPath("") + "orphans_doc" + File.separator + doc;
				File f2 = new File(imgpath);

				p.write(imgpath);
				p2.write(docpath);

				session.setAttribute("succMsg", "Orphans Added Sucessfully");
				resp.sendRedirect("orphange/add_user.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on server");
				resp.sendRedirect("orphange/add_user.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
