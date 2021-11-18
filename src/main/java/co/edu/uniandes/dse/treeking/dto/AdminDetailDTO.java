package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class AdminDetailDTO extends AdminDTO{
    private String password;
    private List<OutingDTO> outings;
}
