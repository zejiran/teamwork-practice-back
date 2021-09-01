package co.edu.uniandes.dse.treeking.entities;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity
public class ComplementaryInformationEntity extends BaseEntity {
	//TODO: add atributes of ComplementaryInformation
	@PodamExclude
	@OneToOne
	private MultimediaEntity homeImage;
}
