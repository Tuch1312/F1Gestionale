package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Dipendente;
import utils.SessionInstance;

public class GestioneDipendente {
	
	public GestioneDipendente () {}
	
	@SuppressWarnings("unchecked")
	public List <Dipendente> getAllDipendenti (){
		
		List <Dipendente> dipendenti = new ArrayList <>();
		
		Session localSession = SessionInstance.getSessionInstance();
		Transaction transaction = localSession.beginTransaction();
		
		try {
			
			dipendenti = localSession.createQuery("from Dipendente").list();
		
		}catch(HibernateException e) {
			
			System.out.println("#ERR C'è stato un errore con il recupero dei dipendenti");
		}
		
		transaction.commit();
		localSession.close();
		
		return dipendenti;
	}
	
	public boolean addDipendente (Dipendente dipendente) {
		
		Session localSession = SessionInstance.getSessionInstance();
		Transaction transaction = localSession.beginTransaction();
		
		try {
			
			localSession.save(dipendente);
		}catch(HibernateException e) {
			
			System.out.println("#ERR C'è stato un errore cercando di aggiungere un dipendente");
			return false;
		}
		
		transaction.commit();
		localSession.close();
		
		return true;
	}
	
	public boolean updateDipendente (Dipendente oldDipendente, Dipendente newDipendente) {
		
		Session localSession = SessionInstance.getSessionInstance();
		Transaction transaction = localSession.beginTransaction();
		
		localSession.evict(oldDipendente);
		 
		oldDipendente.setNome(newDipendente.getNome());
		oldDipendente.setCognome(newDipendente.getCognome());
		oldDipendente.setDataAssunzione(newDipendente.getDataAssunzione());
		oldDipendente.setDataDiNascita(newDipendente.getDataDiNascita());
		oldDipendente.setIndirizzo(newDipendente.getIndirizzo());
		oldDipendente.setLivelloSeniority(newDipendente.getLivelloSeniority());
		oldDipendente.setMansione(newDipendente.getMansione());
		oldDipendente.setMail(newDipendente.getMail());
		oldDipendente.setSottopostoA(newDipendente.getSottopostoA());
		oldDipendente.setTelefono(newDipendente.getTelefono());
		
		try {
			
			localSession.update(oldDipendente);
			
		}catch(HibernateException e) {
			
			System.out.println("#ERR C'è stato un errore durante l'update di un dipendente");
			return false;
		}
		
		transaction.commit();
		localSession.close();
		
		return true;
	}
	
	public Dipendente getDipendente (String personalCode) {
		
		Dipendente dipendente = null;
		
		Session localSession = SessionInstance.getSessionInstance();
		Transaction transaction = localSession.beginTransaction();
		
		try {
			
			dipendente = (Dipendente) localSession.createQuery("from Dipendente d where d.personalCode = '"+personalCode+"'").getSingleResult();
			
		}catch(HibernateException e) {
			
			System.out.println("#ERR C'è stato un errore con il recupero del dipendente");
		}catch(NoResultException e2) {
			
			System.out.println("#ERR C'è stato un errore con il recupero del dipendente");
		}
		
		transaction.commit();
		localSession.close();
		
		return dipendente;
	}
}
