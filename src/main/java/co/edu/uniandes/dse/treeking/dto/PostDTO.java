package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

@Data
public class PostDTO {
	private Long id;

	private Integer ratings;

	private String title;

	private CommentDTO comment;

}
