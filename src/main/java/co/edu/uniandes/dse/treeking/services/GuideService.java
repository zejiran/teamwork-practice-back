package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.GuideEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.GuideRepository;

@Service
public class GuideService {

	@Autowired
	GuideRepository guideRepository;

	@Transactional
	public List<GuideEntity> getGuides() {
		return guideRepository.findAll();
	}

	@Transactional
	public GuideEntity getGuide(Long id) throws EntityNotFoundException {
		Optional<GuideEntity> guide = guideRepository.findById(id);
		if(guide == null) {
			throw new EntityNotFoundException(ErrorMessage.GUIDE_NOT_FOUND);
		}
		return guide.get();
	}
	
}
