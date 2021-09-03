package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class GuideEntity extends BaseEntity {

	private String name;

	private Float rating;

	private Integer age;
	
	@PodamExclude
	@ManyToOne
	private OutingEntity outing;
}
