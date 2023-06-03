package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

@WebServlet("/app")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u=new User("Pabitra", "Pabitra@gmail.com");
		UserDao dao=new UserDao();
		/*
		 * boolean f=dao.saveUser(u); if(f) { System.out.println("Success"); }else {
		 * System.out.println("Error"); }
		 */
		
		/*
		 * User us=dao.getUser(1); System.out.println(us);
		 */
		
		dao.checkUser("Pabitra@gmail.com", "Pabitra2");
		
		
		
	}
	
	

}
