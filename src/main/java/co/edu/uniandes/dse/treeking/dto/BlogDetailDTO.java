package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

import java.util.List;

@Data
public class BlogDetailDTO extends BlogDTO{
    private List<PostDTO> posts;
}
