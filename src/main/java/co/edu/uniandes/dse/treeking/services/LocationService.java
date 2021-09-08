package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.LocationEntity;
import co.edu.uniandes.dse.treeking.repositories.LocationRepository;

@Service
public class LocationService {
	@Autowired
	LocationRepository locationRepository;

	@Transactional
	public List<LocationEntity> getLocations() {
		return locationRepository.findAll();
	}

	@Transactional
	public LocationEntity getPrimerLocation() {
		List<LocationEntity> locaciones = locationRepository.findAll();
		if (locaciones.isEmpty()) {
			return locaciones.get(0);
		} else {
			return null;
		}
	}
}
