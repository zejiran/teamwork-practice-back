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

import co.edu.uniandes.dse.treeking.dto.MultimediaDTO;
import co.edu.uniandes.dse.treeking.dto.MultimediaDetailDTO;
import co.edu.uniandes.dse.treeking.entities.MultimediaEntity;
import co.edu.uniandes.dse.treeking.enums.FileType;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.treeking.services.MultimediaService;

/**
 * Class that implements resource "multimedias"
 */

@RestController
@RequestMapping("/multimedias")
public class MultimediaController {

	@Autowired
	private MultimediaService multimediaService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Search and return all multimedias that exist in the application.
	 *
	 * @return JSONArray {@link MultimediaDTO} - Multimedias find in the
	 *         application. If there are none, it returns an empty list.
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<MultimediaDTO> findAll() {
		List<MultimediaEntity> multimedias = multimediaService.getMultimedias();
		return modelMapper.map(multimedias, new TypeToken<List<MultimediaDTO>>() {
		}.getType());
	}

	/**
	 * Search and return the multimedia with the given id at the URL.
	 *
	 * @param id Identifier of the searched multimedia
	 * @return JSON {@link MultimediaDetailDTO} - The searched multimedia.
	 */
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public MultimediaDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		MultimediaEntity multimediaEntity = multimediaService.getMultimedia(id);
		return modelMapper.map(multimediaEntity, MultimediaDetailDTO.class);
	}

	/**
	 * Save a new multimedia with the URL information and returns it.
	 *
	 * @param book {@link MultimediaDTO} - multimedia to be saved.
	 * 
	 * @return JSON {@link MultimediaDTO}  - Saved Multimedia.
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MultimediaDTO create(@RequestBody MultimediaDTO bookDTO) throws IllegalOperationException, EntityNotFoundException {
		MultimediaEntity multimediaEntity = multimediaService.createMultimedia(modelMapper.map(bookDTO, MultimediaEntity.class));
		return modelMapper.map(multimediaEntity, MultimediaDTO.class);
	}
}
