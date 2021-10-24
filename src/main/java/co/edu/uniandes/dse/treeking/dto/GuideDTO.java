package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import lombok.Data;

@Data
public class GuideDTO {

	private Long id;
	
	private String name;

	private Float rating;

	private Integer age;
	
	private OutingDetailDTO outing;
	
}
