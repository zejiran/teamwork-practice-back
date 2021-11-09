package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.FilesContainerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ReviewDetailDTO extends ReviewDTO{
    private FilesContainerEntity container;
}
