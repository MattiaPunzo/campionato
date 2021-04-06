package it.begear.heroku.campionato.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="squadre")
public class Squadre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_squadra")
	private int id_squadra;
	@Column(name = "nome")
	private String nome;
	@Column(name = "partite_giocate")
	private String partite_giocate;
	@Column(name = "punti")
	private String punti;
	
	public Squadre() {
		
	}

	public int getId_squadra() {
		return id_squadra;
	}

	public void setId_squadra(int id_squadra) {
		this.id_squadra = id_squadra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartite_giocate() {
		return partite_giocate;
	}

	public void setPartite_giocate(String partite_giocate) {
		this.partite_giocate = partite_giocate;
	}

	public String getPunti() {
		return punti;
	}

	public void setPunti(String punti) {
		this.punti = punti;
	}
	
	
}
