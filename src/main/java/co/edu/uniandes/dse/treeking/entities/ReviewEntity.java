package co.edu.uniandes.dse.treeking.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter

public class ReviewEntity extends BaseEntity {

	private Integer score;

	@OneToOne(cascade = CascadeType.ALL)
	private CommentEntity comment;

	@PodamExclude
	@ManyToOne
	private QuotationEntity quotation;

	@PodamExclude
	@OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
	private List<MultimediaEntity> multimedias;

}
