package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.enums.FileType;
import lombok.Data;

@Data
public class MultimediaDTO {
	private String fileName;
	private FileType mediaType;
	private String extension;
	private RouteDTO route;
	private PostDTO post;
	private ComplementaryInformationDTO complementaryInformation;
}
