package co.edu.uniandes.dse.treeking.dto;

import java.util.List;

import co.edu.uniandes.dse.treeking.entities.QuotationEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OutingDetailDTO extends OutingDTO{
	private List<ActivityDTO> activities;
	private List<QuotationDTO> quotations;
	private ComplementaryInformationDTO complementaryInformation;

}
