package co.edu.uniandes.dse.treeking.entities;

import co.edu.uniandes.dse.treeking.enums.Status;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class QuotationEntity extends BaseEntity {

	private Integer participants;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private InsuranceEntity insurance;

	private Integer totalCost;

	private Status status;

	@ManyToOne(cascade = CascadeType.ALL)
	private OutingEntity outing;

	@PodamExclude
	@ManyToOne(cascade = CascadeType.ALL)
	private CalendarEntity calendar;
}
