package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GuideEntity extends BaseEntity {
	
	private String name;
	
	private Float rating;
	
	private Integer age;
}
