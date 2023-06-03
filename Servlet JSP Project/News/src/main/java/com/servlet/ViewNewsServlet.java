package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.NewsDAO;
import com.conn.DBConnect;
import com.entity.News;

@WebServlet("/viewServlet")
public class ViewNewsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsDAO dao=new NewsDAO(DBConnect.getConn());
		List<News> n=dao.getNews();
		//System.out.println(n);
		if(n.isEmpty())
		{
			req.setAttribute("Msg", "No News Available");
			req.getRequestDispatcher("/viewNews.jsp").forward(req, resp);
		}else {
			
			req.setAttribute("newsList", n);
			req.getRequestDispatcher("/viewNews.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


}
