package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class NaturalPersonEntity extends ClientEntity {
	@PodamExclude
	@OneToOne
	private PersonEntity person;
}
