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


	private String routeName;

	private Difficulty difficulty;
	private Integer estimatedDuration;

	@OneToMany(mappedBy = "map", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LocationEntity> locations;

	@OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
	private List<ReviewEntity> reviews = new ArrayList<>();

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private FilesContainerEntity container;

	@PodamExclude
	@ManyToMany(mappedBy = "routes", fetch = FetchType.LAZY)
	private List<OutingEntity> outings;

}