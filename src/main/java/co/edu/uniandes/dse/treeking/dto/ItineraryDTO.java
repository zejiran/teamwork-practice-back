package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ItineraryDTO {

	private Long id;

	private String lodging;

	private String transportation;

}
