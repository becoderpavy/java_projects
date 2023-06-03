package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//@WebServlet("/AdminAddBookServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class demoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("bimg");
		String fileName = part.getSubmittedFileName();

		String uploadPath = getServletContext().getRealPath("")+"book";
		File uploadDir = new File(uploadPath);
		
		part.write(uploadPath + File.separator + fileName);
		System.out.println(uploadPath);
		
//		if (!uploadDir.exists())
//			uploadDir.mkdir();
//
//		for (Part p : req.getParts()) {
//			
//			p.write(uploadPath + File.separator + fileName);
//		}

	}

	

}