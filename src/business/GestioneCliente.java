package business;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
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
		
		try{
			
			Query query = session.createQuery("from Cliente");
			clienti = query.list();
		
		}catch(HibernateException e) {
			
			System.out.println("#ERR C'è stato un errore con il recupero dei clienti");
		}
		
		transaction.commit();
		session.close();
		
		return clienti;
	}
	
	public boolean addCliente(Cliente cliente) {
		
		Session session = SessionInstance.getSessionInstance();
		Transaction transaction = session.beginTransaction();
		
		try {
			
			session.save(cliente);
		}catch(HibernateException e) {
			
			System.out.println("#ERR C'è stato un errore cercando di aggiungere un cliente" );
			return false;
		}
		
		transaction.commit();
		session.close();
		
		return true;
	}
	
	public boolean updateCliente (Cliente oldCliente, Cliente newCliente) {
		
		Session session = SessionInstance.getSessionInstance();
		Transaction transaction = session.beginTransaction();
		
		session.evict(oldCliente);
		
		oldCliente.setNome(newCliente.getNome());
		oldCliente.setSettoreCompetenza(newCliente.getSettoreCompetenza());
		oldCliente.setIndirizzo(newCliente.getIndirizzo());
		oldCliente.setMail(newCliente.getMail());
		oldCliente.setTelefono(newCliente.getTelefono());
		oldCliente.setDataInizioCollaborazione(newCliente.getDataInizioCollaborazione());
		
		try {
			
			session.update(oldCliente);
			
		}catch(HibernateException e){
			
			System.out.println("#ERR C'è stato un errore durante l'update di un dipendente");
			return false;
		}
		
		transaction.commit();
		session.close();
		
		return true;
	}
	
	public  Cliente getCliente(String partitaIva) {
		Cliente cliente = null;
		
		Session session = SessionInstance.getSessionInstance();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Cliente c where c.partitaIva ='"+partitaIva+"'");
		
		try {
			
			
			cliente = (Cliente) query.getSingleResult();
			
		}catch(HibernateException e) {
			
			
			System.out.println("#ERR C'è stato un errore con il recupero del cliente");
		}
		
		transaction.commit();
		session.close();
		
		return cliente;
	}
}
