package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import co.edu.uniandes.dse.treeking.enums.FileType;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class MultimediaEntity extends BaseEntity {
	private String fileName;
	private FileType mediaType;
	private String extension;

	@PodamExclude
	@ManyToOne
	private RouteEntity route;

	@PodamExclude
	@ManyToOne
	private PostEntity post;

	@PodamExclude
	@OneToOne
	private ComplementaryInformationEntity complementaryInformation;
}
