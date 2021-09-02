package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.MultimediaEntity;
import co.edu.uniandes.dse.treeking.repositories.MultimediaRepository;

/**
 * Class that implements the services in the logic of the Multimedia entity.
 */
@Service
public class MultimediaService {

	@Autowired
	MultimediaRepository multimediaRepository;

	/**
	 * Obtains the list of the Multimedia registers.
	 *
	 * @return Object collection of MultimediaEntity.
	 */
	@Transactional
	public List<MultimediaEntity> getMultimedias() {
		return multimediaRepository.findAll();
	}
}