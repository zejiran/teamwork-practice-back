package co.edu.uniandes.dse.treeking.entities;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity
public class PostEntity extends BaseEntity {

	private Integer ratings;
	
	private String title;

	@OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private CommentEntity comment;

	@OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private ContMultimediaEntity container;

	@PodamExclude
	@ManyToOne
	private BlogEntity blog;

}
