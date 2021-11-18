package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import co.edu.uniandes.dse.treeking.enums.FileType;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import java.util.List;

@Entity
@Getter
@Setter
public class MultimediaEntity extends BaseEntity {
	private String fileName;
	private FileType mediaType;
	private String extension;

	@PodamExclude
	@ManyToMany
	private List<FilesContainerEntity> containers;

}
