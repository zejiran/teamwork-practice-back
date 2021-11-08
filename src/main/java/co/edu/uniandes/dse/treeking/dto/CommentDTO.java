package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {
    private Long id;
    private String text;
    private Integer likes;
    private Integer dislikes;
    private Date date;
    private String username;
}
