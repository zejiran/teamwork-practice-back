package co.edu.uniandes.dse.treeking.services;

import java.util.List;

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
}