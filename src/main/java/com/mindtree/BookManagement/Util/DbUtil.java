package com.mindtree.BookManagement.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbUtil {
	
	private DbUtil() {
		
		// TODO Auto-generated constructor stub
	}
	public static SessionFactory sessionfactory;
	public  static SessionFactory createConnection() {

		 if (sessionfactory == null) {
	            sessionfactory = new Configuration().configure("hibernate.cfg.xml").
	                    buildSessionFactory();
	        }
		return sessionfactory;
}
}
