package co.edu.uniandes.dse.treeking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.treeking.entities.NaturalPersonEntity;

/**
 * Interface that persists a natural person
 */
@Repository
public interface NaturalPersonRepository extends JpaRepository<NaturalPersonEntity, Long> {

}
