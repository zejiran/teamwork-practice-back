package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class QuotationDetailDTO extends QuotationDTO {
	private InsuranceDTO insurance;
}
