package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.UserEntity;
import co.edu.uniandes.dse.treeking.repositories.UserRepository;

/**
 * Class that implements the services in the logic of the User entity.
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * Obtains the list of the User registers.
	 *
	 * @return Object collection of UserEntity.
	 */
	@Transactional
	public List<UserEntity> getUsers() {
		return userRepository.findAll();
	}
}