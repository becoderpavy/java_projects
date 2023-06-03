package com.servlet;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class Succ extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String coid = req.getParameter("coid");
		String sid = req.getParameter("sid");
		String cid = req.getParameter("cid");
		String fn = req.getParameter("fn");
		String ln = req.getParameter("ln");
		String msg = "";
		System.out.println(coid + " " + sid + " " + cid + " " + fn + " " + ln);
		// resp.sendRedirect("register.jsp");

		/*
		 * if(fn==null) { msg="enter value"; resp.setContentType("text/plain");
		 * resp.getWriter().write(msg); }else { msg="success";
		 * resp.setContentType("text/plain"); resp.getWriter().write(msg); }
		 */

		LocalTime startTime = LocalTime.parse(fn);

		LocalTime endTime = LocalTime.of(startTime.getHour(), startTime.getMinute()).plusHours(1);

		if (endTime.isAfter(startTime)) {

			if (startTime.isAfter(startTime) && startTime.isBefore(startTime)) {

			} else {
				System.out.println("not available");
			}

		} else {
			System.out.println(endTime.isAfter(startTime));
		}

	}

}
