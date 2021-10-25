package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RouteDetailDTO extends RouteDTO {
    private List<MultimediaDTO> medias; //en el entity lo llamas medias
    private List<LocationDTO> locationsDTOS;
    private List<OutingDTO> outings;
}
