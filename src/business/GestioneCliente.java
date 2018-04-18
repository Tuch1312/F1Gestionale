package business;

import org.hibernate.*;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;

import utils.*;

public class GestioneCliente {
	
	public List<Cliente> getAllClienti(){
		
		List<Cliente> clienti = new List<>();
		
		Session session = SessionInstance.getSessionInstance();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from cliente");
		clienti = query.list();
		transaction.commit();
		session.close();
		
		return clienti;
	}

}
