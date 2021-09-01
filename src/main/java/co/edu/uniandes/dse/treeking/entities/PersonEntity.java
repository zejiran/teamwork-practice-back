package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PersonEntity extends BaseEntity {
	private String name;
	private String idType;
	private String idNumber;
	private String address;
}
