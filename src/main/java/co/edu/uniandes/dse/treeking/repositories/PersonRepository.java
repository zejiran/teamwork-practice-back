package co.edu.uniandes.dse.treeking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.treeking.entities.PersonEntity;

/**
 * Interface that persists a person
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
