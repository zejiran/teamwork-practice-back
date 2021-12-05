package co.edu.uniandes.dse.treeking.services;

import co.edu.uniandes.dse.treeking.entities.CommentEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
		log.info("Inicia proceso de consultar el comentario con id = " +commentId);
		Optional<CommentEntity> CommentEntity = commentRepository.findById(commentId);
		if (CommentEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.COMMENT_NOT_FOUND);
		log.info("Termina proceso de consultar el comentario con id = " +commentId);
		return CommentEntity.get();
	}

	@Transactional
	public CommentEntity create(Long idFather, CommentEntity comment) throws EntityNotFoundException {
		log.info("Inicia proceso de creación del comentario");
		CommentEntity commentFather;
		commentFather = getComment(idFather);
		comment.setComment(commentFather);
		return commentRepository.save(comment);
	}
	@Transactional
	public CommentEntity create(CommentEntity comment) {
		log.info("Inicia proceso de creación del comentario");
		comment.setComment(null);
		return commentRepository.save(comment);
	}
}
