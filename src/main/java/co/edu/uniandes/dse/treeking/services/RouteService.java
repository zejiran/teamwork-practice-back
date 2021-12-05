package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import co.edu.uniandes.dse.treeking.repositories.RouteRepository;


@Slf4j
@Service
public class RouteService {
	@Autowired
	RouteRepository routeRepository;

	@Transactional
	public List<RouteEntity> getRoutes() {
		return routeRepository.findAll();
	}


	public RouteEntity getRouteById(Long id) throws EntityNotFoundException {
		Optional<RouteEntity> routeEntity = routeRepository.findById(id);
		if (routeEntity.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.ROUTE_NOT_FOUND);
		}
		return routeEntity.get();
	}

	@Transactional
	public RouteEntity createRoute(RouteEntity admin) {
		log.info("Inicia proceso de creación de la ruta");
		return routeRepository.save(admin);
	}
}
