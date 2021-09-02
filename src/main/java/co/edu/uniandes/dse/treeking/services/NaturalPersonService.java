package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.NaturalPersonEntity;
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
}