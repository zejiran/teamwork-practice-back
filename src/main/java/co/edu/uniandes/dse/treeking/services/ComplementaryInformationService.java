package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.ComplementaryInformationEntity;
import co.edu.uniandes.dse.treeking.repositories.ComplementaryInformationRepository;

@Service
public class ComplementaryInformationService {
	@Autowired
	ComplementaryInformationRepository complementaryinformationRepository;

	@Transactional
	public List<ComplementaryInformationEntity> getComplementaryInformations() {
		return complementaryinformationRepository.findAll();
	}
}
