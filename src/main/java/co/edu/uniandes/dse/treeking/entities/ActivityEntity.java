package co.edu.uniandes.dse.treeking.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter 

public class ActivityEntity extends BaseEntity {
	
	private String name;
	
	private String description;
	
	private LocalDateTime time;
	
	private Integer minutes;
	
	
}
