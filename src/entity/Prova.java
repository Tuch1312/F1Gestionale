package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.SessionInstance;

public class Prova {
	
	public static void main (String [] args) {
		
		GestioneCliente gc = new GestioneCliente();
		List<Cliente> clienti =  new  List<>();
		clienti = gc.getAllClienti();
		
		for(Clienti c : clienti)
			System.out.print(c.getPersonaICode()+","+c.getNome()+","+c.getCognome());
		/*Session session = SessionInstance.getSessionInstance();
		
		Transaction trans = session.beginTransaction();
		
		Dipendente dipendente = new Dipendente();
		dipendente.setPersonalCode("lorenzo");
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
		*/
	}

}
