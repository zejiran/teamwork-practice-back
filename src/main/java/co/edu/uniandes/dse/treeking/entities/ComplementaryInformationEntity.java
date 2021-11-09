package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class ComplementaryInformationEntity extends BaseEntity {

	private String description;

	private String recomendation;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private MultimediaEntity homeImage;

}
