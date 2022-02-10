package com.product.listners;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DriverListner implements ServletContextListener{

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		String driverName=sce.getServletContext().getInitParameter("driver");
		
		try {
			Class.forName(driverName);
			System.out.println("Driver is loaded...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	
	
	
	
}
