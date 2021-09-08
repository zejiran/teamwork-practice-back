package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdminDetailDTO extends AdminDTO{

    private List<CommentDTO> comments;
    private List<OutingDTO> outings;
}
