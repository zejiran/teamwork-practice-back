package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class BlogEntity extends BaseEntity {
	private String username;
	private Long userId;
	private String userType;
	@OneToMany(mappedBy = "blog", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostEntity> posts;
}
