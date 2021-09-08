package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OutingDetailDTO extends OutingDTO{
	private ActivityDTO activities;
	private GuideDTO guides;
	private ComplementaryInformationDTO complementaryInformation;
	private ReviewDTO review;
	private RouteDTO routes;
}
