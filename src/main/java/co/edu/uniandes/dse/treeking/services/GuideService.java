package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.GuideEntity;
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
	public GuideEntity getGuide(Long id) {
		return null;

	}

	@Transactional
	public void updateGuide(Long id, GuideEntity guide) {
	}

	@Transactional
	public void deleteGuide() {

	}
}
