package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.conn.ConnectionProvider;
import com.entity.userDtls;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String email=req.getParameter("email");
			String pass=req.getParameter("password");
			UserDAOImpl dao=new UserDAOImpl(ConnectionProvider.getConnection());
			
			userDtls normalUser=dao.loginUser(email, pass);
			
			userDtls adminUser=new userDtls();
			adminUser.setName("Admin");
			adminUser.setEmail(email);
			adminUser.setPassword(pass);
			
			HttpSession session=req.getSession();
			
			if("admin@gmail.com".equals(email) && "admin@121".equals(pass))
			{
				session.setAttribute("admin",adminUser);
				resp.sendRedirect("admin/adminHome.jsp");
			}
			else if(normalUser!=null)
			{
				session.setAttribute("LoginUser", normalUser);
				resp.sendRedirect("index.jsp");
			}
			else 
			{
				session.setAttribute("errorMsg", "Email & Password invalid");
				resp.sendRedirect("login.jsp");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
