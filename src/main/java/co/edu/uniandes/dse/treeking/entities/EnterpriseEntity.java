package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
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
	
	@PodamExclude
	@OneToOne
	protected PersonEntity representative;
}
