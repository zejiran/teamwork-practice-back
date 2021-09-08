package co.edu.uniandes.dse.treeking.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OutingDetailDTO extends OutingDTO{
	private List<ActivityDTO> activities;
	private List<GuideDTO> guides;
	private ComplementaryInformationDTO complementaryInformation;
	private ReviewDTO review;
	private List<RouteDTO> routes;
}
