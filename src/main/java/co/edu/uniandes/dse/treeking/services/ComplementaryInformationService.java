package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.ComplementaryInformationEntity;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.ComplementaryInformationRepository;

@Service
public class ComplementaryInformationService {
	@Autowired
	ComplementaryInformationRepository complementaryinformationRepository;

	@Transactional
	public List<ComplementaryInformationEntity> getComplementaryInformations() {
		return complementaryinformationRepository.findAll();
	}
	
	@Transactional
	public ComplementaryInformationEntity getComplementaryInformation(long id) throws EntityNotFoundException{
		ComplementaryInformationEntity ci =complementaryinformationRepository.findById(id).orElse(null);
		if (ci == null) {
			throw new EntityNotFoundException(ErrorMessage.COMPLEMENTARYINFORMATION_NOT_FOUND);
		}
		return ci;
	}
}
