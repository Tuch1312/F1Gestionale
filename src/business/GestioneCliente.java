package business;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import utils.SessionInstance;

import entity.Cliente;

public class GestioneCliente {
	
	public List <Cliente> getAllClienti(){
		
		List <Cliente> clienti = new ArrayList <>();
		
		Session session = SessionInstance.getSessionInstance();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from cliente");
		clienti = query.list();
		transaction.commit();
		session.close();
		
		return clienti;
	}

}
