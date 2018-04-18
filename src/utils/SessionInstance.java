package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Dipendente;

public class SessionInstance {
	
	private static SessionFactory factory;
	private static Session session;
	
	private SessionInstance () {}
	
	public static Session getSessionInstance () {
		
		if (factory == null || session == null) {
			
			factory = new Configuration().configure("entity/hibernate.cfg.xml")
					.addAnnotatedClass(Dipendente.class).buildSessionFactory();
			
			session = factory.getCurrentSession();
		}
		
		return session;
	}

}
