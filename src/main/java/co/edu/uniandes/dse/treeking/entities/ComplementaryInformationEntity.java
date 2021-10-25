package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class ComplementaryInformationEntity extends BaseEntity {

	private String description;

	private String recomendation;

	@OneToOne(mappedBy = "complementaryInformation") //necesitas mappedBy?
	private MultimediaEntity homeImage;

	@PodamExclude
	@OneToOne
	private OutingEntity outing;
}
