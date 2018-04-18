package entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import business.GestioneDipendente;

public class Interfaccia {
	
	public static void main (String [] args) {
		
		Scanner scanner = null;
		
		GestioneDipendente gd = new GestioneDipendente();
		
		List <Dipendente> dipendenti = null;
		Dipendente dipendente = null;
		Dipendente nuovoDipendente = null;
		String personalCode = null;
		
		System.out.println("********************");
		System.out.println("Digita 1 per stampare le informazioni di tutti i dipendenti");
		System.out.println("Digita 2 per cercare un dipendente utilizzando un personalCode");
		System.out.println("Digita 3 per assumere un dipendente");
		System.out.println("Digita 4 per aggiornare le info di un dipendente");
		System.out.println("____________________");
		
		boolean esci = false;
		int cmd = 0;
		
		do {
			
			scanner = new Scanner (System.in);
			
			System.out.println();
			System.out.println("Cosa vuoi fare?");
			
			try {
				
				cmd = scanner.nextInt();
			}catch(NumberFormatException e) {
				
				cmd = 0;
			}catch(NoSuchElementException e2) {
				
				cmd = 0;
			}
			
			switch (cmd) {
			
				case 1:
					
					System.out.println();
					System.out.println("# INFORMAZIONI DI TUTTI I DIPENDENTI");
					
					dipendenti = gd.getAllDipendenti();
					for (Dipendente d : dipendenti)
						System.out.println(d.toString());
					
					System.out.println("____________________");
					
					break;
					
				case 2:
					
					System.out.println();
					System.out.println("# RICERCA DI UN DIPENDENTE TRAMITE PERSONAL CODE");
					
					System.out.println();
					System.out.println("Inserisci un personal code ... ");
					System.out.print("");	
					
					scanner = new Scanner (System.in);
					
					personalCode = scanner.nextLine();
					dipendente = gd.getDipendente(personalCode);
					
					if (dipendente != null) 
						
						System.out.println(dipendente.toString());
					else
						System.out.println("Nella base dati non esiste alcun dipendente con il personal code "+personalCode);
						
					System.out.println("____________________");
					
					break;
					
				case 3:
					
					System.out.println();
					System.out.println("# ASSUMI UN DIPENDENTE");
					
					dipendente = routineInitializeUpdateDipendente(true);
					
					if(dipendente != null)	
						gd.addDipendente(dipendente);
					
					System.out.println("____________________");
					
					break;
					
				case 4:
					
					System.out.println();
					System.out.println("# AGGIORNA INFORMAZIONI DIPENDENTE");
					
					System.out.println();
					System.out.println("Di quale dipendente vuoi aggiornare i dati? (Inserisci il suo persona code) ");
					personalCode = scanner.nextLine();
					
					dipendente = gd.getDipendente(personalCode);
					
					if (dipendente == null) 
					
						System.out.println("Nella base dati non esiste alcun dipendente con il personal code "+personalCode);
					
					nuovoDipendente = routineInitializeUpdateDipendente(false);
					
					gd.updateDipendente(dipendente, nuovoDipendente);
					
					System.out.println("____________________");
					
					break;
			
				case -1:
					
					esci = true;
					scanner.close();
					System.out.println("# Sei uscito");
					break;
					
				default:
					
					System.out.println("# Comando non riconosciuto");
					break;
			}
			
		}while(!esci);
	}
	
	public static Dipendente routineInitializeUpdateDipendente (boolean nuovoDipendente) {
		
		Scanner scanner = new Scanner (System.in);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()); 
		
		Dipendente dipendente = new Dipendente();
		
		
		if(nuovoDipendente) {
			
			System.out.println();
			System.out.println("Inserisci personal code ... ");
				
			String personalCode = scanner.nextLine();
				
			if(personalCode != null)
				if(!personalCode.equals(""))
					dipendente.setPersonalCode(personalCode);
			
		}
		
		System.out.println();
		System.out.println("Inserisci nome ... ");
		
		dipendente.setNome(scanner.nextLine());
		
		System.out.println();
		System.out.println("Inserisci cognome ... ");
		
		dipendente.setCognome(scanner.nextLine());
		
		System.out.println();
		System.out.println("Inserisci indirizzo ... ");
		
		dipendente.setIndirizzo(scanner.nextLine());
		
		System.out.println();
		System.out.println("Inserisci mail ... ");
		
		dipendente.setMail(scanner.nextLine());
		
		System.out.println();
		System.out.println("Inserisci telefono ... ");
		
		dipendente.setTelefono(scanner.nextLine());
		
		System.out.println();
		System.out.println("Inserisci mansione ... ");
		
		dipendente.setMansione(scanner.nextLine());
		
		System.out.println();
		System.out.println("Inserisci livello seniority ... ");
		
		dipendente.setLivelloSeniority(scanner.nextLine());
		
		System.out.println();
		System.out.println("Inserisci sottoposto a ... ");
		
		dipendente.setSottopostoA(scanner.nextLine());
		
		if(dipendente.getSottopostoA().equals(""))
			dipendente.setSottopostoA(null);
		
		System.out.println();
		System.out.println("Inserisci data di nascita ... "); 
		
		try {
			
			dipendente.setDataDiNascita(dateFormat.parse(scanner.nextLine()));
		} catch (ParseException e) {
			
			System.out.println("#ERR Data non formata correttamente");
		}
		
		System.out.println();
		System.out.println("Inserisci data di assunzione ... ");
		
		try {
			
			dipendente.setDataAssunzione(dateFormat.parse(scanner.nextLine()));
		} catch (ParseException e) {
			
			System.out.println("#ERR Data non formata correttamente");
		}
		
		scanner.close();
		
		return dipendente;
	}

}
