package it.prova.materialrest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "ruolo")
public class Ruolo {
	
	public static final String ROLE_ADMIN	= "ROLE_ADMIN";
	public static final String ROLE_CLASSIC_USER	= "ROLE_CLASSIC_USER";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codice")
	private String codice;
	@Column(name = "descrizione")
	private String descrizione;
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ruolo")
	List<User> users = new ArrayList<>();
}
