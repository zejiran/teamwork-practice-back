package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

@Data
public class QuotationDTO {
	private Long id;
	private Integer participants;
	private Float totalCost;
	private OutingDTO outing;
}