package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

import java.util.List;

@Data
public class CommentDetailDTO extends CommentDTO{
    private List<CommentDTO> comments;
}
