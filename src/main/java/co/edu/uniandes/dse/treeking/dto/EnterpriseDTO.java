package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

@Data
public class EnterpriseDTO {
	private Long id;
	private String user;
	private PersonDTO representative;
	private CalendarDTO calendar;
}
