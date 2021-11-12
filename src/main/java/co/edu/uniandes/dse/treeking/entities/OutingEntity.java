package co.edu.uniandes.dse.treeking.entities;

import co.edu.uniandes.dse.treeking.podam.DateStrategy;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class OutingEntity extends BaseEntity {
	private String name;

	@Temporal(TemporalType.DATE)
	@PodamStrategyValue(DateStrategy.class)
	private Date date;

	private String place;

	private Integer participationCost;

	@PodamExclude
	@ManyToMany
	private List<RouteEntity> routes;

	@PodamExclude
	@OneToOne
	private ComplementaryInformationEntity complementaryInformation;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ItineraryEntity itinerary;

	@PodamExclude
	@OneToMany(mappedBy = "outing")
	private List<ActivityEntity> activities;

	@ManyToMany(mappedBy = "outings", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<GuideEntity> guides;

	@PodamExclude
	@OneToMany(mappedBy = "outing", fetch = FetchType.LAZY)
	private List<QuotationEntity> quotations;

}
