package com.contact.conifg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitlizer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		//System.out.println("dispatcher calling");
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(SpringMvcConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
				new DispatcherServlet(appContext));

		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
