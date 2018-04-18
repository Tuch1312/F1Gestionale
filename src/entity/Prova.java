package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.SessionInstance;

public class Prova {
	
	public static void main (String [] args) {
		
		Session session = SessionInstance.getSessionInstance();
		
		Transaction trans = session.beginTransaction();
		
		Dipendente dipendente = new Dipendente();
		dipendente.setPersonalCode("giacomo");
		dipendente.setNome("prova");
		dipendente.setCognome("prove");
		dipendente.setDataAssunzione(new Date());
		dipendente.setDataDiNascita(new Date());
		dipendente.setIndirizzo("prova");
		dipendente.setLivelloSeniority("prova");
		dipendente.setMansione("prova");
		dipendente.setMail("prova");
		dipendente.setSottopostoA(null);
		dipendente.setTelefono("prova");
		
		
			
		session.save(dipendente);
		trans.commit();
		
	}

}
