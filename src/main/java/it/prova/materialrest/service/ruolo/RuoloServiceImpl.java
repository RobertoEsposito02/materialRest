package it.prova.materialrest.service.ruolo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.materialrest.model.Ruolo;
import it.prova.materialrest.repository.ruolo.RuoloRepository;

@Service
public class RuoloServiceImpl implements RuoloService{

	@Autowired
	private RuoloRepository repository;
	
	@Override
	public List<Ruolo> listAll() {
		return (List<Ruolo>) repository.findAll();
	}

	@Override
	public Ruolo caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void aggiorna(Ruolo ruoloInstance) {
		repository.save(ruoloInstance);
	}

	@Override
	public void inserisciNuovo(Ruolo ruoloInstance) {
		repository.save(ruoloInstance);
	}

	@Override
	public void rimuovi(Long idToRemove) {
		repository.deleteById(idToRemove);
	}

	@Override
	public Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) {
		return repository.findByCodiceAndDescrizione(codice, descrizione);
	}

}
