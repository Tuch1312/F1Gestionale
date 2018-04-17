package entity;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name ="cliente")
public class Cliente {
	
	@Id
	@Column(name = "partita_iva")
	private String partitaIva;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "settore_competenza")
	private String settoreCompetenza;
	
	@Column(name = "indirizzo")
	private String indirizzo;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "data_inizio_collaborazione")
	@Temporal(TemporalType.DATE)
	private Date dataInizioCollaborazione;
	
	
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
	public Date getDataInizioCollaborazione() {
		return dataInizioCollaborazione;
	}
	public void setDataInizioCollaborazione(Date dataInizioCollaborazione) {
		this.dataInizioCollaborazione = dataInizioCollaborazione;
	}

	
	
}
