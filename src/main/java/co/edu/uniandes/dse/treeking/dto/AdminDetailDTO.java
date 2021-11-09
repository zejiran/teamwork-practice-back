package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class AdminDetailDTO extends AdminDTO{

    private List<CommentDTO> comments;
    private List<OutingDTO> outings;
}
