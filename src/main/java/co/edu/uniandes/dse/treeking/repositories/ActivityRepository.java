package co.edu.uniandes.dse.treeking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.treeking.entities.ActivityEntity;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

}
