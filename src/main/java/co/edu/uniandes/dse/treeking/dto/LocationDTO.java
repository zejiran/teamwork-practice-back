package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private Integer idLocation;
    private String locationName;
    private float latitude;
    private float longitude;
    private RouteDTO map;
}
