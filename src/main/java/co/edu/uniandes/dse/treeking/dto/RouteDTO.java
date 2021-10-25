package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.enums.Difficulty;
import lombok.Data;

@Data
public class RouteDTO {
    private String name;
	private Difficulty difficulty;
    private Float estimatedDuration;
}
