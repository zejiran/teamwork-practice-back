package co.edu.uniandes.dse.treeking.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.treeking.entities.BlogEntity;
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Long>{
}
