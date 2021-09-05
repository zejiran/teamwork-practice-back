package co.edu.uniandes.dse.treeking.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter

public class ReviewEntity extends BaseEntity {
	@ElementCollection
	private List<Integer> ratings = new ArrayList<>();
	@OneToMany
	private List<CommentEntity> reviews = new ArrayList<>();

	@PodamExclude
	@ManyToOne
	private RouteEntity review;

}
