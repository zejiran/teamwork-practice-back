package co.edu.uniandes.dse.treeking.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.treeking.dto.PostDTO;
import co.edu.uniandes.dse.treeking.dto.PostDetailDTO;
import co.edu.uniandes.dse.treeking.dto.TransactionDTO;
import co.edu.uniandes.dse.treeking.entities.PostEntity;
import co.edu.uniandes.dse.treeking.entities.TransactionEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.services.PostService;

/**
 * Clase que implementa el recurso "posts"
 *
 */

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Busca y devuelve todos los posts que existen en la aplicacion.
	 *
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<PostDTO> findAll() {
		List<PostEntity> posts = postService.getPosts();
		return modelMapper.map(posts, new TypeToken<List<PostDTO>>() {
		}.getType());
	}

	/**
	 * Busca el post con el id asociado recibido en la URL y lo devuelve.
	 *
	 * @param postId Identificador del post que se esta buscando. Este debe ser una
	 *               cadena de dígitos.
	 * @return JSON {@link PostDetailDTO} - El post buscado
	 */
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public PostDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		PostEntity postEntity = postService.getPost(id);
		return modelMapper.map(postEntity, PostDetailDTO.class);
	}
	
	/**
	 * Crea un nuevo post con la informacion que se recibe en el cuerpo de la
	 * petición y se regresa un objeto identico con un id auto-generado por la base
	 * de datos.
	 *
	 * @param postDTO {@link PostDTO} - El post que se desea
	 *                       guardar.
	 * @return JSON {@link PostDTO} - El post guardado con el atributo
	 *         id autogenerado.
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PostDTO create(@RequestBody PostDTO postDTO) {
		PostEntity postEntity = postService
				.createPost(modelMapper.map(postDTO, PostEntity.class));
		return modelMapper.map(postEntity, PostDTO.class);
	}

}