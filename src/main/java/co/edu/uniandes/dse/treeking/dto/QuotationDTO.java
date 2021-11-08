package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.InsuranceEntity;
import lombok.Data;
import co.edu.uniandes.dse.treeking.enums.Status;

@Data
public class QuotationDTO {
	private Long id;
	private Integer participants;
	private Float totalCost;
	private Status status;
	private OutingDTO outing;
}
