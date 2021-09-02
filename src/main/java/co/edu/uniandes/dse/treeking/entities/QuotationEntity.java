package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;
import co.edu.uniandes.dse.treeking.enums.Status;

@Getter
@Setter
@Entity
public class QuotationEntity extends BaseEntity {

	private Integer participants;

	@PodamExclude
	@OneToOne
	private InsuranceEntity insurance;

	private Integer totalCost;

	private Status status;

	@PodamExclude
	@ManyToOne
	private OutingEntity outing;


	@PodamExclude
	@ManyToOne
	private CalendarEntity quotation;

}
