package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@OneToOne(mappedBy = "complementaryInformation", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //necesitas mappedBy?
	private MultimediaEntity homeImage;

	@PodamExclude
	@OneToOne
	private OutingEntity outing;
}
