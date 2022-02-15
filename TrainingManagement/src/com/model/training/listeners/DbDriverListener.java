package com.model.training.listeners;

import javax.servlet.ServletContextEvent;

public class DbDriverListener {

	public void contextInitialized(ServletContextEvent sce) {
		String driverName=sce.getServletContext().getInitParameter("jdbc.driver");
		try {
			Class.forName(driverName);
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}
}
