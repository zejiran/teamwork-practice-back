package co.edu.uniandes.dse.treeking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.treeking.entities.EnterpriseEntity;

public interface EnterpriseRepository extends JpaRepository<EnterpriseEntity, Long> {
}
