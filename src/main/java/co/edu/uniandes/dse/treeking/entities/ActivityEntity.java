package co.edu.uniandes.dse.treeking.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter

public class ActivityEntity extends BaseEntity {

	private String name;

	private String description;

	private LocalDateTime time;

	private Integer minutes;

	@PodamExclude
	@ManyToOne
	private OutingEntity outing;

}
