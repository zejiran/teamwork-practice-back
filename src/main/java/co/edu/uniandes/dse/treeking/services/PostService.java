package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.PostEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.PostRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	/**
	 * Se encarga de crear un Post en la base de datos.
	 *
	 * @param post Objeto de PostEntity con los datos nuevos
	 * @return Objeto de PostEntity con los datos nuevos y su ID.
	 */
	@Transactional
	public PostEntity createPost(PostEntity post) {
		log.info("Inicia proceso de creación del post");
		return postRepository.save(post);
	}

	@Transactional
	public List<PostEntity> getPosts() {
		return postRepository.findAll();
	}

	/**
	 * Obtiene los datos de una instancia de Post a partir de su ID.
	 *
	 * @param postId Identificador de la instancia a consultar
	 * @return Instancia de PostEntity con los datos del post consultado.
	 */
	@Transactional
	public PostEntity getPost(Long postId) throws EntityNotFoundException {
		Optional<PostEntity> postEntity = postRepository.findById(postId);
		if (postEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.POST_NOT_FOUND);
		return postEntity.get();
	}
}
