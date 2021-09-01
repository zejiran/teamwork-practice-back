package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity
public class MultimediaEntity extends BaseEntity {
	
	@PodamExclude
	@ManyToOne
	private PostEntity post;
}