package co.edu.uniandes.dse.treeking.entities;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity extends BaseEntity {
	protected String user;
	protected String password;
	protected String mail;

	@OneToOne
	private BlogEntity blog; //en vez de la lista de post que tenga el blog que tiene la lista

}
