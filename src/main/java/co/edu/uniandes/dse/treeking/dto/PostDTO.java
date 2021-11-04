package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.BlogEntity;
import co.edu.uniandes.dse.treeking.entities.UserEntity;
import lombok.Data;

@Data
public class PostDTO {
	private Integer ratings;
	private BlogEntity blog;
	private UserEntity user;	

	private String title;

	// deberia llamar al DTO en vez de al entity y sobra
	// sobra si esta en el comment
	private CommentDTO commentDTO;
}
