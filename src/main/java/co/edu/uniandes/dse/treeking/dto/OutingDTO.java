package co.edu.uniandes.dse.treeking.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OutingDTO {
	private Long id;
	private String name;
	private Date date;
	private String place;
	private Integer participationCost;
	private ItineraryDTO itinerary;
	private RouteDTO route;
	private GuideDTO guide;
}
