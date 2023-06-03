package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.CountyDAO;
import com.entity.City;
import com.entity.Country;
import com.entity.State;
import com.google.gson.Gson;

@WebServlet("/GetCountryStateservlet")
public class CountryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String op = request.getParameter("operation");
			CountyDAO dao = new CountyDAO(DBConnect.getConnection());

			if (op.equals("country")) {
				List<Country> clist = dao.getAllCountry();
				Gson json = new Gson();
				String countryList=json.toJson(clist);
				response.setContentType("text/html");
				response.getWriter().write(countryList);
			}
			
			  if (op.equals("state")) {
	                int id = Integer.parseInt(request.getParameter("id"));
	                List<State> slist = dao.getStateByCountryId(id);
	                Gson json = new Gson();
	                String countryList = json.toJson(slist);
	                response.setContentType("text/html");
	                response.getWriter().write(countryList);
	            }

	            if (op.equals("city")) {
	                int id = Integer.parseInt(request.getParameter("id"));
	                List<City> citylist = dao.getCityByStateId(id);
	                Gson json = new Gson();
	                String countryList = json.toJson(citylist);
	                response.setContentType("text/html");
	                response.getWriter().write(countryList);
	            }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
