package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.BlogEntity;
import co.edu.uniandes.dse.treeking.entities.FilesContainerEntity;
import co.edu.uniandes.dse.treeking.entities.UserEntity;
import lombok.Data;

@Data
public class PostDTO {
	private Long id;

	private Integer ratings;

	private String title;

	private CommentDTO commentDTO;

}
