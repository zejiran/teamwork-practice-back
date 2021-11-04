package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.NaturalPersonEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.NaturalPersonRepository;

/**
 * Class that implements the services in the logic of the NaturalPerson entity.
 */
@Service
public class NaturalPersonService {

	@Autowired
	NaturalPersonRepository naturalPersonRepository;

	/**
	 * Obtains the list of the NaturalPerson registers.
	 *
	 * @return Object collection of NaturalPersonEntity.
	 */
	@Transactional
	public List<NaturalPersonEntity> getNaturalPersons() {
		return naturalPersonRepository.findAll();
	}

	/**
	 * Obtains the NaturalPerson register by id.
	 *
	 * @param id Identifier of the NaturalPerson register.
	 * @return Instance that coincides with the identifier.
	 * @throws Exception If the NaturalPerson is not found.
	 */
	@Transactional
	public NaturalPersonEntity getNaturalPerson(Long id) throws EntityNotFoundException {
		NaturalPersonEntity naturalPerson = naturalPersonRepository.findById(id).orElse(null);
		if (naturalPerson == null) {
			throw new EntityNotFoundException(ErrorMessage.NATURAL_PERSON_NOT_FOUND);
		}
		return naturalPerson;
	}
}