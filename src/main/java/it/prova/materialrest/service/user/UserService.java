package it.prova.materialrest.service.user;

import java.util.List;

import it.prova.materialrest.model.User;

public interface UserService {
	public List<User> listAllUtenti();

	public User caricaSingoloUtente(Long id);

	public User caricaSingoloUtenteConRuoli(Long id);

	public void aggiorna(User utenteInstance);

	public void inserisciNuovo(User utenteInstance);

	public void rimuovi(Long idToRemove);

	public List<User> findByExample(User example);

	public User findByUsernameAndPassword(String username, String password);

	public User eseguiAccesso(String username, String password);

	public void changeUserAbilitation(Long utenteInstanceId);
	
	public User cercaPerUsername(String username);
}
