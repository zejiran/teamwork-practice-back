package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.ItineraryEntity;
import co.edu.uniandes.dse.treeking.repositories.ItineraryRepository;

@Service
public class ItineraryService {

	@Autowired
	ItineraryRepository itineraryRepository;

	@Transactional
	public List<ItineraryEntity> getItineries() {
		return itineraryRepository.findAll();
	}

}
