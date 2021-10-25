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

	@OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CommentEntity comment;

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<MultimediaEntity> multimedias;

	@PodamExclude
	@ManyToOne
	private BlogEntity blog;




}
