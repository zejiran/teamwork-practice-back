package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import co.edu.uniandes.dse.treeking.entities.ReviewEntity;
import co.edu.uniandes.dse.treeking.entities.ReviewEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.ReviewEntity;
import co.edu.uniandes.dse.treeking.repositories.ReviewRepository;

/**
 * Clase que implementa los servicios de la lógica de la entidad Review.Para
 * esto, se conecta a la clase que maneja la persistencia ReviewRepository.
 *
 * @author ISIS2603
 */
@Slf4j
@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	/**
	 * Obtiene la lista de los registros de Review.
	 *
	 * @return Colección de objetos de ReviewEntity.
	 */
	@Transactional
	public List<ReviewEntity> getReviews() {
		return reviewRepository.findAll();
	}

	@Transactional
	public ReviewEntity getReview(Long reviewId) throws EntityNotFoundException {
		log.info("Inicia proceso de consultar la review con id = " + reviewId);
		Optional<ReviewEntity> ReviewEntity = reviewRepository.findById(reviewId);
		if (ReviewEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.REVIEW_NOT_FOUND);
		log.info("Termina proceso de consultar la review con id = " + reviewId);
		return ReviewEntity.get();
	}

	@Transactional
	public ReviewEntity createReview(ReviewEntity review) {
		log.info("Inicia proceso de creación del autor");
		return reviewRepository.save(review);
	}
}
