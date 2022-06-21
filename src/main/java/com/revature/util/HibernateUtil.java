package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Helper class
 * which handles startup and access of Hibernates Session Factory
 * to obtain a session object (connection to the DB)
 *
 */
public class HibernateUtil {
	
	private static Session ses; //similar to Connection interface from JDBC API
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public static Session getSession() {
		//call on our SessionFactory to open a connection if there isn't one
		if(ses == null) {
			ses = sf.openSession();
		}
		return ses;  //return the new session or existing session
	}
	
	public static void closeSes() {
		ses.close();  //closing frees up connection to the db and returns it to the connection pool
	}
}
