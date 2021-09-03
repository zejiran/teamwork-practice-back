package co.edu.uniandes.dse.treeking.services;

import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import co.edu.uniandes.dse.treeking.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        if ( rutas.size() > 0 ){
            return rutas.get(0);
        } else {
            return null;
        }
    }
}
