package co.edu.uniandes.dse.treeking.repositories;

import co.edu.uniandes.dse.treeking.entities.FilesContainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesContainerRepository extends JpaRepository<FilesContainerEntity, Long> {
}

