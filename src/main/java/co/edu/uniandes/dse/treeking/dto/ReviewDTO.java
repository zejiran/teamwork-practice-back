package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.QuotationEntity;
import lombok.Data;

@Data
public class ReviewDTO{
    private CommentDTO comment;
    private Integer score;
    private QuotationDTO quotation;
}
