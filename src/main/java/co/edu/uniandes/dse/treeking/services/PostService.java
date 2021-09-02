package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.PostEntity;
import co.edu.uniandes.dse.treeking.repositories.PostRepository;

public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public List<PostEntity> getPosts() {
		return postRepository.findAll();
	}	
}
