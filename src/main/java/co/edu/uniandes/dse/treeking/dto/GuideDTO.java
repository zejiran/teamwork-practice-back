package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GuideDTO {

	private Long id;

	private String name;

	private Integer points;

	private Integer reviews;

	private Integer age;

}
