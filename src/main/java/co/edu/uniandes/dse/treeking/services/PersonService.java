package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.PersonEntity;
import co.edu.uniandes.dse.treeking.repositories.PersonRepository;

/**
 * Class that implements the services in the logic of the Person entity.
 */
@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	/**
	 * Obtains the list of the Person registers.
	 *
	 * @return Object collection of PersonEntity.
	 */
	@Transactional
	public List<PersonEntity> getPersons() {
		return personRepository.findAll();
	}
}
