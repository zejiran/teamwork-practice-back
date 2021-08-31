package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity extends BaseEntity {
	protected String user;
	protected String password;
	protected String mail;
}
