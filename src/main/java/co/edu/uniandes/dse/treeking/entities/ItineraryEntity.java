package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItineraryEntity extends BaseEntity {

	private String lodging;

	private String transportation;
}
