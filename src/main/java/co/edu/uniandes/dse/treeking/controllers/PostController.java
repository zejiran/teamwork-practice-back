package co.edu.uniandes.dse.treeking.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.treeking.dto.PostDTO;
import co.edu.uniandes.dse.treeking.entities.PostEntity;
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
} 