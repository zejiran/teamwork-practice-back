package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.CommentEntity;
import co.edu.uniandes.dse.treeking.repositories.CommentRepository;

/**
 * Clase que implementa los servicios de la lógica de la entidad Comment.Para
 * esto, se conecta a la clase que maneja la persistencia CommentRepository.
 *
 * @author ISIS2603
 */

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;

	/**
	 * Obtiene la lista de los registros de Comment.
	 *
	 * @return Colección de objetos de CommentEntity.
	 */
	@Transactional
	public List<CommentEntity> getComments() {
		return commentRepository.findAll();
	}
}