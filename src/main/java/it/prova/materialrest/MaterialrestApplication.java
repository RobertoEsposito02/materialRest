package it.prova.materialrest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.materialrest.model.Ruolo;
import it.prova.materialrest.model.User;
import it.prova.materialrest.service.user.UserService;

@SpringBootApplication
public class MaterialrestApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MaterialrestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ruolo adminRole = Ruolo.builder()
				.codice(Ruolo.ROLE_ADMIN)
				.descrizione("admin")
				.build();
		
		User admin = User.builder()
				.id(1L)
				.username("admin")
				.password("admin")
				.dataDiNascita(LocalDate.now())
				.nome("mario")
				.cognome("rossi")
				.ruolo(adminRole)
				.build();
		
		userService.inserisciNuovo(admin);
	}

}
