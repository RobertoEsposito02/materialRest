package it.prova.materialrest.dto.ruolo;

import java.util.List;
import java.util.stream.Collectors;

import it.prova.materialrest.model.Ruolo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@NoArgsConstructor 
@AllArgsConstructor
public class RuoloDTO {
	private Long id;
	private String codice;
	private String descrizione;
	
	
	public Ruolo buildRuoloModelFromDTO() {
		Ruolo result = Ruolo.builder()
				.id(id)
				.codice(codice)
				.descrizione(descrizione)
				.build();
		
		return result;
	}
	
	public static RuoloDTO buildDtoRuoloFromModel(Ruolo ruoloModel) {
		RuoloDTO result = RuoloDTO.builder()
				.id(ruoloModel.getId())
				.codice(ruoloModel.getCodice())
				.descrizione(ruoloModel.getDescrizione())
				.build();
		
		return result;
	}
	
	
	public static List<Ruolo> buildRuoloListModel(List<RuoloDTO> ruoloDTOList){
		return ruoloDTOList.stream().map(ruolo -> {
			return ruolo.buildRuoloModelFromDTO();
		}).collect(Collectors.toList());
	}
	
	public static List<RuoloDTO> buildRuoloDTOListFromModel(List<Ruolo> ruoloListModel){
		return ruoloListModel.stream().map(ruolo -> {
			return RuoloDTO.buildDtoRuoloFromModel(ruolo);
		}).collect(Collectors.toList());
	}
	
}
