package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class ClientEntity extends BaseEntity {
	
	@PodamExclude
	@OneToOne(cascade = CascadeType.ALL)
	private CalendarEntity calendar;
	
	@PodamExclude
	@ManyToOne
	protected TransactionEntity transactions;
}
