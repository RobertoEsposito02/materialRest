package it.prova.materialrest.repository.ruolo;

import org.springframework.data.repository.CrudRepository;

import it.prova.materialrest.model.Ruolo;

public interface RuoloRepository extends CrudRepository<Ruolo, Long>{
	
	Ruolo findByCodiceAndDescrizione(String codice, String descrizione);
}
