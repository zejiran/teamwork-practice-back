package co.edu.uniandes.dse.treeking.repositories;

import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
}
