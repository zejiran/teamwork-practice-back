package co.edu.uniandes.dse.treeking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.treeking.entities.InsuranceEntity;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {

}
