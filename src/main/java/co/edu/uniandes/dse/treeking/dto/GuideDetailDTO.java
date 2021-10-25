package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

import java.util.List;

@Data
public class GuideDetailDTO extends GuideDTO{
    private List<OutingDTO> outings;
}
