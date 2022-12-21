package it.prova.materialrest.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.materialrest.model.User;
import it.prova.materialrest.repository.user.UserRepository;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> listAllUtenti() {
		return (List<User>) repository.findAll();
	}

	@Override
	public User caricaSingoloUtente(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public User caricaSingoloUtenteConRuoli(Long id) {
		return repository.findByIdEager(id);
	}

	@Override
	public void aggiorna(User utenteInstance) {
		repository.save(utenteInstance);
	}

	@Override
	public void inserisciNuovo(User utenteInstance) {
		repository.save(utenteInstance);
	}

	@Override
	public void rimuovi(Long idToRemove) {
		repository.deleteById(idToRemove);
	}

	@Override
	public List<User> findByExample(User example) {
		return null;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User eseguiAccesso(String username, String password) {
		return null;
	}

	@Override
	public void changeUserAbilitation(Long utenteInstanceId) {
		
	}

	@Override
	public User cercaPerUsername(String username) {
		return repository.findByUsername(username);
	}

}
