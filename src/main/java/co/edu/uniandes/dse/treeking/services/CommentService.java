package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import co.edu.uniandes.dse.treeking.entities.CommentEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

	@Transactional
	public CommentEntity getComment(Long commentId) throws EntityNotFoundException {
		log.info("Inicia proceso de consultar el comentario con id = {0}", commentId);
		Optional<CommentEntity> CommentEntity = commentRepository.findById(commentId);
		if (CommentEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.COMMENT_NOT_FOUND);
		log.info("Termina proceso de consultar el comentario con id = {0}", commentId);
		return CommentEntity.get();
	}
}