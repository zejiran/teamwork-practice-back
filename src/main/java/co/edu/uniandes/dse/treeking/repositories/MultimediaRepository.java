package co.edu.uniandes.dse.treeking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.treeking.entities.MultimediaEntity;

/**
 * Interface that persists multimedia
 */
@Repository
public interface MultimediaRepository extends JpaRepository<MultimediaEntity, Long> {

}
