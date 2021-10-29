package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class GuideEntity extends BaseEntity {

	private String name;

	private Integer point; //el total
	private Integer reviews;

	private Integer age;

	@PodamExclude
	@ManyToMany() //un guia puede ir a varios outings
	private List<OutingEntity> outings;
}
