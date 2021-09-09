package co.edu.uniandes.dse.treeking.dto;

import java.time.LocalDateTime;


import lombok.Data;

@Data
public class ActivityDTO {

	private Long id;
	
	private String name;

	private String description;

	private LocalDateTime time;

	private Integer minutes;
	
	private OutingDTO outing;
}
