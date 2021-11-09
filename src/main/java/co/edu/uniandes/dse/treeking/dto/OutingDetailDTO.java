package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.GuideEntity;
import co.edu.uniandes.dse.treeking.entities.QuotationEntity;
import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class OutingDetailDTO extends OutingDTO{
	private List<ActivityDTO> activities;
	private ComplementaryInformationDTO complementaryInformation;
	private List<GuideEntity> guides;
	private List<RouteEntity> routes;
}
