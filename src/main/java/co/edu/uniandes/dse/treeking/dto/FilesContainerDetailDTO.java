package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.MultimediaEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class FilesContainerDetailDTO extends FilesContainerDTO {
	private List<MultimediaEntity> files;
}
