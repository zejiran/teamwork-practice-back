package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter

public class ReviewEntity extends BaseEntity {

	private Integer score;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CommentEntity comment;

	@PodamExclude
	@ManyToOne
	private RouteEntity route;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private FilesContainerEntity container;

}
