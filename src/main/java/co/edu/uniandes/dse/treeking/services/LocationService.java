package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.LocationEntity;
import co.edu.uniandes.dse.treeking.repositories.LocationRepository;
@Slf4j
@Service
public class LocationService {
	@Autowired
	LocationRepository locationRepository;

	@Transactional
	public List<LocationEntity> getLocations() {
		return locationRepository.findAll();
	}


	public LocationEntity getLocationById(Long LocationId) throws EntityNotFoundException {
		Optional<LocationEntity> locationEntity = locationRepository.findById(LocationId);
		if (locationEntity.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.LOCATION_NOT_FOUND);
		}
		return locationEntity.get();
	}
	@Transactional
	public LocationEntity createLocation(LocationEntity location) {
		log.info("Inicia proceso de creación de la location");
		return locationRepository.save(location);
	}
}
