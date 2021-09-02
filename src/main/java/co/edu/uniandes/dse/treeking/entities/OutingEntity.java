package co.edu.uniandes.dse.treeking.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.uniandes.dse.treeking.podam.DateStrategy;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Getter
@Setter
@Entity
public class OutingEntity extends BaseEntity{
	private String name;
	
	@Temporal(TemporalType.DATE)
	@PodamStrategyValue(DateStrategy.class)
	private Date date;
	
	private String place;
	
	private Integer participationCost;
	
	@PodamExclude
	@OneToMany(mappedBy = "outing", 
			   cascade = CascadeType.PERSIST, 
			   fetch = FetchType.LAZY, 
			   orphanRemoval = true)
	private List<RouteEntity> routes;
	
	@PodamExclude
	@OneToOne
	private ComplementaryInformationEntity complementaryInformation;
	
	@PodamExclude
	@OneToOne
	private ItineraryEntity itinerary;
	
	@PodamExclude
	@OneToOne
	private ReviewEntity review;
	
	@PodamExclude
	@ManyToOne
	private ActivityEntity activities;
	
	@PodamExclude
	@ManyToOne
	private GuideEntity guides;
	
	@PodamExclude
	@OneToMany(mappedBy = "outing",
			   fetch = FetchType.LAZY)
	private List<QuotationEntity> quotation;

	
}
