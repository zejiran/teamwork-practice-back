package co.edu.uniandes.dse.treeking.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity
public class UserEntity extends BaseEntity{
	
	@PodamExclude
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<PostEntity> posts;
}
