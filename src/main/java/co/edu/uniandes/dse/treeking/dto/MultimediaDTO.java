package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.enums.FileType;
import lombok.Data;

@Data
public class MultimediaDTO {
	private String fileName;
	private FileType mediaType;
	private String extension;
	// esto no deberia estar en el DTO es solo algo para la persistencia
	// esto no deberia estar en el DTO
	// esto no deberia estar en el DTO
}
