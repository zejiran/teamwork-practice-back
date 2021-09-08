package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import co.edu.uniandes.dse.treeking.repositories.RouteRepository;

@Service
public class RouteService {
	@Autowired
	RouteRepository routeRepository;

	@Transactional
	public List<RouteEntity> getRoutes() {
		return routeRepository.findAll();
	}

	@Transactional
	public RouteEntity getPrimerRoute() {
		List<RouteEntity> rutas = routeRepository.findAll();
		if (rutas.isEmpty()) {
			return rutas.get(0);
		} else {
			return null;
		}
	}
}
