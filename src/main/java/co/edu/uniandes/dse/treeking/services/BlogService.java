package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import co.edu.uniandes.dse.treeking.entities.BlogEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.BlogEntity;
import co.edu.uniandes.dse.treeking.repositories.BlogRepository;

/**
 * Clase que implementa los servicios de la lógica de la entidad Blog.Para esto,
 * se conecta a la clase que maneja la persistencia BlogRepository.
 *
 * @author ISIS2603
 */

@Slf4j
@Service
public class BlogService {

	@Autowired
	BlogRepository blogRepository;

	/**
	 * Obtiene la lista de los registros de Blog.
	 *
	 * @return Colección de objetos de BlogEntity.
	 */
	@Transactional
	public List<BlogEntity> getBlogs() {
		return blogRepository.findAll();
	}

	@Transactional
	public BlogEntity getBlog(Long blogId) throws EntityNotFoundException {
		log.info("Inicia proceso de consultar el blog con id = {0}", blogId);
		Optional<BlogEntity> BlogEntity = blogRepository.findById(blogId);
		if (BlogEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.BLOG_NOT_FOUND);
		log.info("Termina proceso de consultar el blog con id = {0}", blogId);
		return BlogEntity.get();
	}
}
