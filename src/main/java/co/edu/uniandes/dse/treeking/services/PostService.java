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

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

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
