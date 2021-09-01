package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ComplementaryInformationEntity extends BaseEntity{
	
	private String description;
	
	private String recomendation; 
}
