package entity;

import java.util.ArrayList;
import java.util.List;

import business.GestioneDipendente;

public class Prova {
	
	public static void main (String [] args) {
		
		GestioneDipendente gd = new GestioneDipendente();
		List <Dipendente> dipendenti = new ArrayList <>();
		dipendenti = gd.getAllDipendenti();
		
		for (Dipendente d : dipendenti)
			System.out.println(d.getPersonalCode()+", "+d.getNome()+", "+d.getCognome());
		
		Dipendente dipendenteDaAggiornare = dipendenti.get(0);
		
		Dipendente newDipendente = dipendenteDaAggiornare;
		newDipendente.setNome("Lorenzo");
		newDipendente.setCognome("Garavaglia");
		
		gd.updateDipendente(dipendenteDaAggiornare, newDipendente);
		
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
		trans.commit();*/
		
	}

}
