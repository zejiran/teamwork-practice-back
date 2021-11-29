package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class BlogDetailDTO extends BlogDTO {
	private Long userId;
	private String userType;
	private List<PostDTO> posts;
}
