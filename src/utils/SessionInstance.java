package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Dipendente;

public class SessionInstance {
	
	private static SessionFactory factory;
	
	private SessionInstance () {}
	
	public static Session getSessionInstance () {
		
		if (factory == null)
			
			factory = new Configuration().configure("utils/hibernate.cfg.xml")
					.addAnnotatedClass(Dipendente.class).buildSessionFactory();
		
		
		return factory.getCurrentSession();
	}

}
