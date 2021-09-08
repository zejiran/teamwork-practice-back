package co.edu.uniandes.dse.treeking.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDetailDTO extends PostDTO {
	private List<MultimediaDTO> multimedia = new ArrayList<>();
	private List<CommentDTO> comments = new ArrayList<>();	
}
