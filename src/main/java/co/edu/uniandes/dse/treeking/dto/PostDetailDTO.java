package co.edu.uniandes.dse.treeking.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PostDetailDTO extends PostDTO {
	private List<MultimediaDTO> multimedias = new ArrayList<>();
	private List<CommentDTO> comments = new ArrayList<>();	
}
