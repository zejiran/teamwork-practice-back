package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class OutingDetailDTO extends OutingDTO{
	private List<ActivityDTO> activities;
	private List<QuotationDTO> quotations;
	private ComplementaryInformationDTO complementaryInformation;

}
