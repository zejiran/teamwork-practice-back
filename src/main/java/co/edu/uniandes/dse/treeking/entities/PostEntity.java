package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity
public class PostEntity extends BaseEntity {
	
	private Integer ratings;
	
	
	// Implementar clases
	
	/*
	@PodamExclude
	@ManyToOne
	private MultimediaEntity multimedia;
	*/
	
	/*
	@PodamExclude
	@ManyToOne
	private BlogEntity blog;
	*/
	
	/*
	@PodamExclude
	@ManyToOne
	private CommentEntity comment;
	*/
	
	/*
	@PodamExclude
	@ManyToOne
	private UserEntity user;
	*/

}
