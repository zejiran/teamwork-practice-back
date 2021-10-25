package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class GuideEntity extends BaseEntity {

	private String name;

	private Float rating; //si queremos que ese valor se actualice debería ser una lista de calificaciones,
							//  o podríamos ponerle el valor promedio de calificación de las salidas a las que asistió
	private Integer age;

	@PodamExclude
	@OneToMany(mappedBy = "guide") //un guia puede ir a varios outings
	private List<OutingEntity> outings;
}
