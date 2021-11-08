package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;


@Data
public class ComplementaryInformationDTO{

	private Long id;

	private String description;

	private String recommendation;
	
	private MultimediaDTO homeImage;
	
	// no creo que sea necesario
	
}
