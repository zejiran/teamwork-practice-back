package co.edu.uniandes.dse.treeking.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class CommentEntity extends BaseEntity {
	private String text;

	@PodamExclude
	@OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
	private List<CommentEntity> replies = new ArrayList<>();

	@PodamExclude
	@ManyToOne
	private CommentEntity comment;

}
