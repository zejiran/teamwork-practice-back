package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class PostEntity extends BaseEntity {
	// TODO: add attributes of post entity.
	@PodamExclude
	@ManyToOne
	private UserEntity user;
}
