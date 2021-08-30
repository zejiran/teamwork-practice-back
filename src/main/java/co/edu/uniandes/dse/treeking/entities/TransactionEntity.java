package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TransactionEntity extends BaseEntity {
	
	enum PAYMENT {
		CREDITCARD, DEBITCARD
	}
	
	private PAYMENT payment;
	private Integer value;
	
	/*
	@Temporal(TemporalType.DATE)
	private Date date;
	 */
	
	/*
	@PodamExclude
	@ManyToOne
	private ClientEntity client;
	*/
}
