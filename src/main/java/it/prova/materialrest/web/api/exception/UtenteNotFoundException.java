package it.prova.materialrest.web.api.exception;

public class UtenteNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UtenteNotFoundException(String message) {
		super(message);
	}
}
