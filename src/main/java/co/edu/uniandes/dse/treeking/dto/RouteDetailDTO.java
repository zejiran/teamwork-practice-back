package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.FilesContainerEntity;
import co.edu.uniandes.dse.treeking.entities.LocationEntity;
import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import co.edu.uniandes.dse.treeking.entities.ReviewEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class RouteDetailDTO extends RouteDTO {

    private List<LocationEntity> locations;

    private List<ReviewEntity> reviews = new ArrayList<>();

    private FilesContainerEntity container;
}
