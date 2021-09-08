package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RouteDetailDTO extends RouteDTO {
    private List<MultimediaDTO> multimediaDTO;
    private List<ReviewDTO> reviewDTO;
    private List<LocationDTO> locationsDTOS;
}
