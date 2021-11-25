package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.MultimediaEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
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

	/**
	 * Obtains the Multimedia register by id.
	 *
	 * @param id Identifier of the Multimedia register.
	 * @return Instance that coincides with the identifier.
	 * @throws Exception If the identifier does not exist.
	 */
	@Transactional
	public MultimediaEntity getMultimedia(Long id) throws EntityNotFoundException {
		MultimediaEntity multimedia = multimediaRepository.findById(id).orElse(null);
		if (multimedia == null) {
			throw new EntityNotFoundException(ErrorMessage.MULTIMEDIA_NOT_FOUND);
		}
		return multimedia;
	}
	
	/**
	 * Creates a Multimedia in the database.
	 *
	 * @param multimedia Object of MultimediaEntity with the new data.
	 * @return Object of MultimediaEntity with the new data and it corresponding ID.
	 */
	@Transactional
	public MultimediaEntity createMultimedia(MultimediaEntity multimedia) {
	    return multimediaRepository.save(multimedia);
	}
}