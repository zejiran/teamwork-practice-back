package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.MultimediaEntity;
import lombok.Data;

import java.util.List;

@Data
public class ReviewDetailDTO extends ReviewDTO{
    List<MultimediaEntity> multimedias;
}
