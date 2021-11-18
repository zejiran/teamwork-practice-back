package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NaturalPersonEntity extends BaseEntity {
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PersonEntity person;
}
