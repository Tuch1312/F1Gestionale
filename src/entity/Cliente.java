package entity;

import java.util.Date;

public class Cliente {
	
	private String partitaIva;
	private String nome;
	private String settoreCompetenza;
	private String indirizzo;
	private String telefono;
	private String mail;
	private Date dataInizio;
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSettoreCompetenza() {
		return settoreCompetenza;
	}
	public void setSettoreCompetenza(String settoreCompetenza) {
		this.settoreCompetenza = settoreCompetenza;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	
}
