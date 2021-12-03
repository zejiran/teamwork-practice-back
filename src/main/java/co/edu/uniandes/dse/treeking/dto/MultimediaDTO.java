package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.enums.FileType;
import lombok.Data;

@Data
public class MultimediaDTO {
	private Long id;
	private String fileName;
	private FileType mediaType;
	private String extension;
}
