package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.PostEntity;
import lombok.Data;

@Data
public class CommentDTO {
    private String text;
    private Integer likes;
    private Integer dislikes;
    private PostEntity post;
}
