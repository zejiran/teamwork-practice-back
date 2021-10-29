package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.*;

import co.edu.uniandes.dse.treeking.enums.Status;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class QuotationEntity extends BaseEntity {

	private Integer participants;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private InsuranceEntity insurance;

	private Integer totalCost;

	private Status status;

	@ManyToMany
	private List<OutingEntity> outings;

	@PodamExclude
	@ManyToOne
	private CalendarEntity calendar;
}
