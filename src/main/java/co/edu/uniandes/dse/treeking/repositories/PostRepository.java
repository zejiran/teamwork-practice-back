package co.edu.uniandes.dse.treeking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.treeking.entities.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
