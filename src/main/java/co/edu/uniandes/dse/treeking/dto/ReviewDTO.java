package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

@Data
public class ReviewDTO{
    private CommentDTO comment;
    private Integer rating;
}
