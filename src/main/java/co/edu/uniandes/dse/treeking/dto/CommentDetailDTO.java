package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class CommentDetailDTO extends CommentDTO {
    private String userID;
    private String userType;
    private List<CommentDTO> replies;
}
