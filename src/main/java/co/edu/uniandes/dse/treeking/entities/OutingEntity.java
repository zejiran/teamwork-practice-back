package co.edu.uniandes.dse.treeking.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import co.edu.uniandes.dse.treeking.podam.DateStrategy;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Getter
@Setter
@Entity
public class OutingEntity extends BaseEntity {
	private String name; //el nombre no beria ir solo en la ruta?

	@Temporal(TemporalType.DATE)
	@PodamStrategyValue(DateStrategy.class)
	private Date date;

	private String place;

	private Integer participationCost;

	@PodamExclude
	@ManyToOne
	private RouteEntity route; // la relación estaba al revés

	@PodamExclude
	@OneToOne(mappedBy = "outing")
	private ComplementaryInformationEntity complementaryInformation;

	@PodamExclude
	@OneToOne
	private ItineraryEntity itinerary;

	@PodamExclude
	@OneToMany(mappedBy = "outing")
	private List<ActivityEntity> activities;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private GuideEntity guide; //considero que solo debería tener un guia, si pudiesen haber mas, seria manyToMany

	@PodamExclude
	@OneToMany(mappedBy = "outing", fetch = FetchType.LAZY)
	private List<QuotationEntity> quotations;


}
