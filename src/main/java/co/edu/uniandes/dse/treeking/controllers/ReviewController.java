package co.edu.uniandes.dse.treeking.controllers;

import co.edu.uniandes.dse.treeking.dto.ReviewDTO;
import co.edu.uniandes.dse.treeking.entities.ReviewEntity;
import co.edu.uniandes.dse.treeking.services.ReviewService;
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
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ReviewDTO> findAll() {
		List<ReviewEntity> reviews = reviewService.getReviews();
		return modelMapper.map(reviews, new TypeToken<List<ReviewDTO>>() {
		}.getType());
	}
}