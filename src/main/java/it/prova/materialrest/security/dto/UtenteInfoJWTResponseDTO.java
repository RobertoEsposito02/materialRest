package it.prova.materialrest.security.dto;

import java.time.LocalDate;

import it.prova.materialrest.model.Ruolo;

public class UtenteInfoJWTResponseDTO {

	private String nome;
	private String cognome;
	private String type = "Bearer";
	private String username;
	private LocalDate dataDiNascita;
	private Ruolo ruolo;

	public UtenteInfoJWTResponseDTO(LocalDate dataDiNascita,String nome, String cognome, String username, Ruolo ruolo) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.dataDiNascita = dataDiNascita;
		this.ruolo = ruolo;
	}

	public String getTokenType() {
		return type;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
	
}