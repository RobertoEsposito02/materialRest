package it.prova.materialrest.web.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.materialrest.dto.user.UserDTO;
import it.prova.materialrest.model.Ruolo;
import it.prova.materialrest.model.User;
import it.prova.materialrest.security.dto.UtenteInfoJWTResponseDTO;
import it.prova.materialrest.service.user.UserService;
import it.prova.materialrest.web.api.exception.IdNotNullForInsertException;
import it.prova.materialrest.web.api.exception.IdNullForUpdateException;
import it.prova.materialrest.web.api.exception.UtenteNotFoundException;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService utenteService;
	
	@GetMapping("/testSoloAdmin")
	public String test() {
		return "OK";
	}

	@GetMapping(value = "/userInfo")
	public ResponseEntity<UtenteInfoJWTResponseDTO> getUserInfo() {

		// se sono qui significa che sono autenticato quindi devo estrarre le info dal
		// contesto
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		// estraggo le info dal principal
		User utenteLoggato = utenteService.cercaPerUsername(username);
		Ruolo ruolo = utenteLoggato.getRuolo();

		return ResponseEntity.ok(new UtenteInfoJWTResponseDTO(utenteLoggato.getDataDiNascita(),utenteLoggato.getNome(), utenteLoggato.getCognome(),
				utenteLoggato.getUsername(), ruolo));
	}
	
	@GetMapping
	public List<UserDTO> listAll(){
		return UserDTO.buildListDTOFromModel(utenteService.listAllUtenti());
	}
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable(required = true) Long id) {
		User utenteDaCaricare = utenteService.caricaSingoloUtente(id);
		if(utenteDaCaricare == null)
			throw new UtenteNotFoundException("utente non trovato");
		
		return UserDTO.buildUserDTOFromModel(utenteDaCaricare);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void inserisci(@Valid @RequestBody UserDTO utente) {
		if(utente.getId() != null)
			throw new IdNotNullForInsertException("impossibile aggiungere un record se contenente id");
		
		utenteService.inserisciNuovo(utente.buildUserModel());
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@Valid @RequestBody UserDTO utente) {
		if(utente.getId() == null)	
			throw new IdNullForUpdateException("impossibile aggiornare un record se non si inserisce l'id");
		
		utenteService.aggiorna(utente.buildUserModel());
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true) Long id) {
		User utenteDaEliminare = utenteService.caricaSingoloUtente(id);
		if(utenteDaEliminare == null)
			throw new UtenteNotFoundException("utente non trovato");
		
		utenteService.rimuovi(id);
	}
}
