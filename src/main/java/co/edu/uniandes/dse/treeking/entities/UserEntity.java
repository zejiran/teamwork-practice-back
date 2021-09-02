package co.edu.uniandes.dse.treeking.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class UserEntity extends BaseEntity {
	protected String user;
	protected String password;
	protected String mail;

	@PodamExclude
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<PostEntity> posts;
}
