package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class TransactionEntity extends BaseEntity {
	// TODO: add attributes of transaction entity.
	@PodamExclude
	@ManyToOne
	private ClientEntity client;
}
