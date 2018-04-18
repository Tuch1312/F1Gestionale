package business;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Dipendente;
import utils.SessionInstance;

public class GestioneDipendente {
	
	public List <Dipendente> getAllDipendenti (){
		
		List <Dipendente> dipendenti = new ArrayList <>();
		
		Session session = SessionInstance.getSessionInstance();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Dipendente");
		dipendenti = query.list();
		
		transaction.commit();
		session.close();
		
		return dipendenti;
	}

}
