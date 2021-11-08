package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

@Data
public class UserDTO {
	private Long id;
	private String user;
	private String password;
	private String mail;
	private BlogDTO blog;
}
