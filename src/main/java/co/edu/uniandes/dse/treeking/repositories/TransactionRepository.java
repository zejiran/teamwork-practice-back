package co.edu.uniandes.dse.treeking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.treeking.entities.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>{

}
