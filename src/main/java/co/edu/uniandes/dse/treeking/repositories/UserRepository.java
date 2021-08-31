package co.edu.uniandes.dse.treeking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.treeking.entities.UserEntity;

/**
 * Interface that persists an user
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
