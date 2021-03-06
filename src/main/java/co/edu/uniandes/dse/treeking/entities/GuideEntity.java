package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class GuideEntity extends BaseEntity {

	private String name;

	private Integer points;

	private Integer reviews;

	private Integer age;

	@PodamExclude
	@ManyToMany()
	private List<OutingEntity> outings;
}
