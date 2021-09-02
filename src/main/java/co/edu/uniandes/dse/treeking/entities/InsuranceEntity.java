package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InsuranceEntity extends BaseEntity {
	private String features;
	private String conditions;
	private String name;
	private Integer price;
}
