package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.MultimediaEntity;
import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import lombok.Data;

@Data
public class ComplementaryInformationDTO {
	
	private Long id;
	
	private String description;

	private String recomendation;
	
	private MultimediaDTO homeImage;
	
	private OutingDetailDTO outing;
	
}
