package co.edu.uniandes.dse.treeking.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.treeking.dto.UserDTO;
import co.edu.uniandes.dse.treeking.entities.UserEntity;
import co.edu.uniandes.dse.treeking.services.UserService;

/**
 * Class that implements resource "users"
 */

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Search and return all users that exist in the application.
	 *
	 * @return JSONArray {@link UserDTO} - Users find in the application. If there
	 *         are none, it returns an empty list.
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserDTO> findAll() {
		List<UserEntity> users = userService.getUsers();
		return modelMapper.map(users, new TypeToken<List<UserDTO>>() {
		}.getType());
	}
}
