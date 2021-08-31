package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class LocationEntity extends BaseEntity {
	
	private Integer idLocation;
	private Float latitude;
	private Float longitude;
}
