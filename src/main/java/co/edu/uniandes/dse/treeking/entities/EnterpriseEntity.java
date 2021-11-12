package co.edu.uniandes.dse.treeking.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una empresa en la persistencia
 *
 * @author Phelyxx
 */

@Getter
@Setter
@Entity
public class EnterpriseEntity extends BaseEntity {

	protected String user;
	protected String password;
	protected String mail;

	@OneToOne(cascade = CascadeType.ALL)
	private CalendarEntity calendar;

	@PodamExclude
	@OneToMany(mappedBy = "enterprise", fetch = FetchType.LAZY)
	protected List<TransactionEntity> transactions;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BlogEntity blog;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	protected PersonEntity representative;
}
