package co.edu.uniandes.dse.treeking.controllers;

import co.edu.uniandes.dse.treeking.dto.BlogDTO;
import co.edu.uniandes.dse.treeking.entities.BlogEntity;
import co.edu.uniandes.dse.treeking.services.BlogService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<BlogDTO> findAll() {
		List<BlogEntity> blogs = blogService.getBlogs();
		return modelMapper.map(blogs, new TypeToken<List<BlogDTO>>() {
		}.getType());
	}
}