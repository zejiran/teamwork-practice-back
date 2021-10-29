package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class ComplementaryInformationEntity extends BaseEntity {

	private String description;

	private String recomendation;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private MultimediaEntity homeImage;

}
