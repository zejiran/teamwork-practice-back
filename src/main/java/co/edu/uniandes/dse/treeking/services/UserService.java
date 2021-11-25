package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.UserEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
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

	/**
	 * Obtains the User register by id.
	 *
	 * @param id Identifier of the User register.
	 * @return Instance that coincides with the identifier.
	 * @throws Exception If the identifier does not exist.
	 */
	@Transactional
	public UserEntity getUser(Long id) throws EntityNotFoundException {
		UserEntity user = userRepository.findById(id).orElse(null);
		if (user == null) {
			throw new EntityNotFoundException(ErrorMessage.USER_NOT_FOUND);
		}
		return user;
	}
	
	/**
	 * Creates a User in the database.
	 *
	 * @param user Object of UserEntity with the new data.
	 * @return Object of UserEntity with the new data and it corresponding ID.
	 */
	@Transactional
	public UserEntity createUser(UserEntity user) {
	    return userRepository.save(user);
	}
}
