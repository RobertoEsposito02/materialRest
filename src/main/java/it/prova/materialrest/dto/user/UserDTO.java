package it.prova.materialrest.dto.user;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import it.prova.materialrest.model.Ruolo;
import it.prova.materialrest.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserDTO {
	
	private Long id;
	private String username;
	private String password;
	private String confermaPassword;
	private LocalDate dataDiNascita;
	private String nome;
	private String cognome;
	private Ruolo ruolo;
	
	public User buildUserModel() {
		User result = User.builder()
				.id(id)
				.username(username)
				.password(password)
				.dataDiNascita(dataDiNascita)
				.nome(nome)
				.cognome(cognome)
				.ruolo(ruolo)
				.build();
		
		return result;
	}
	
	public static UserDTO buildUserDTOFromModel(User userModel) {
		UserDTO result = UserDTO.builder()
				.id(userModel.getId())
				.username(userModel.getUsername())
				.password(userModel.getPassword())
				.dataDiNascita(userModel.getDataDiNascita())
				.nome(userModel.getNome())
				.cognome(userModel.getCognome())
				.ruolo(userModel.getRuolo())
				.build();
		
		return result;
	}
	
	public static List<User> buildModelListFromDTO(List<UserDTO> userListDTO){
		return userListDTO.stream().map(utente -> {
			return utente.buildUserModel();
		}).collect(Collectors.toList());
	}
	
	public static List<UserDTO> buildListDTOFromModel(List<User> userListModel){
		return userListModel.stream().map(utente -> {
			return UserDTO.buildUserDTOFromModel(utente);
		}).collect(Collectors.toList());
	}
	
}
