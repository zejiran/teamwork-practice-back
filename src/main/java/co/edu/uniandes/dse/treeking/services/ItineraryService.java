package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.ActivityEntity;
import co.edu.uniandes.dse.treeking.entities.ItineraryEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.treeking.repositories.ItineraryRepository;

@Service
public class ItineraryService {

	@Autowired
	ItineraryRepository itineraryRepository;

	@Transactional
	public List<ItineraryEntity> getItineries() {
		return itineraryRepository.findAll();
	}

	@Transactional
	public ItineraryEntity getItinerary(long id) throws EntityNotFoundException {
		Optional<ItineraryEntity> itinerary = itineraryRepository.findById(id);
		if (itinerary == null) {
			throw new EntityNotFoundException(ErrorMessage.ITINERARY_NOT_FOUND);
		}
		return itinerary.get();
	}

	@Transactional
	public ItineraryEntity createItinerary(ItineraryEntity itinerary) throws IllegalOperationException {
		return itineraryRepository.save(itinerary);
	}
}
