package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.OutingRepository;

@Service
public class OutingService {

	@Autowired
	OutingRepository outingRepository;

	/**
	 * Obtiene la lista de los registros de Outing.
	 * 
	 * @return Colección de objetos de outingEntity.
	 */
	@Transactional
	public List<OutingEntity> getOutings() {
		return outingRepository.findAll();
	}

	/**
	 * Obtiene los datos de una instancia Outing a través de su id
	 * 
	 * @param outingId Identificar de la instancia a consultar
	 * @return Instancia de Outing que coincide con id pasado por parametro.
	 * @throws IllegalOperationException
	 * @throws EntityNotFoundException
	 */
	@Transactional
	public OutingEntity getOuting(Long outingId) throws EntityNotFoundException {
		Optional<OutingEntity> outingEntity = outingRepository.findById(outingId);
		if (outingEntity.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.OUTING_NOT_FOUND);
		}
		return outingEntity.get();
	}
}
