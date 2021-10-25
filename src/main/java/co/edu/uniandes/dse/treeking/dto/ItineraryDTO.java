package co.edu.uniandes.dse.treeking.dto;




import lombok.Data;


@Data
public class ItineraryDTO {

	private Long id;
	
	private String lodging;

	private String transportation;

	private OutingDTO outing; //TODO esto sobra
}
