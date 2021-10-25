package co.edu.uniandes.dse.treeking.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import co.edu.uniandes.dse.treeking.enums.Difficulty;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Setter
@Getter
@Entity
public class RouteEntity extends BaseEntity {

	private String name; // creo que debería tener un nombre
	private Difficulty difficulty;
	private Integer estimatedDuration;

	@PodamExclude
	@OneToMany(mappedBy = "map", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LocationEntity> locations;


	@PodamExclude
	@OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
	private List<MultimediaEntity> medias = new ArrayList<>();

	@PodamExclude
	@OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
	private List<OutingEntity> outings;  // la relación estaba al revés

}