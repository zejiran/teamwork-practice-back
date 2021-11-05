package co.edu.uniandes.dse.treeking.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	@PodamExclude
	@OneToMany(mappedBy = "map", fetch = FetchType.LAZY)
	private List<LocationEntity> locations = new ArrayList<>();

	@PodamExclude
	@OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
	private List<ReviewEntity> reviews = new ArrayList<>();

	@PodamExclude
	@OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
	private List<MultimediaEntity> medias = new ArrayList<>();

	@PodamExclude
	@ManyToOne
	private OutingEntity outing;

}