package co.edu.uniandes.dse.treeking.dto;


import co.edu.uniandes.dse.treeking.entities.FilesContainerEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PostDetailDTO extends PostDTO {
	private FilesContainerEntity container;
}
