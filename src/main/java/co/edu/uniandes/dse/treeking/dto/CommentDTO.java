package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String text;
    private Integer likes;
    private Integer dislikes;
}
