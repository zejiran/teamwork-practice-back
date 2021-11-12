package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity extends BaseEntity {
	protected String user;
	protected String password;
	protected String mail;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BlogEntity blog;

}
