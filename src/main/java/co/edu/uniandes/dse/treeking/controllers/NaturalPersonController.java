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

import co.edu.uniandes.dse.treeking.dto.NaturalPersonDTO;
import co.edu.uniandes.dse.treeking.dto.NaturalPersonDetailDTO;
import co.edu.uniandes.dse.treeking.entities.NaturalPersonEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.treeking.services.NaturalPersonService;

/**
 * Class that implements resource "persons/natural"
 */

@RestController
@RequestMapping("/persons/natural")
public class NaturalPersonController {

	@Autowired
	private NaturalPersonService naturalPersonService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Search and return all naturalPersons that exist in the application.
	 *
	 * @return JSONArray {@link NaturalPersonDTO} - NaturalPersons find in the
	 *         application. If there are none, it returns an empty list.
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<NaturalPersonDTO> findAll() {
		List<NaturalPersonEntity> naturalPersons = naturalPersonService.getNaturalPersons();
		return modelMapper.map(naturalPersons, new TypeToken<List<NaturalPersonDTO>>() {
		}.getType());
	}

	/**
	 * Search and return the natural person with the given id at the URL.
	 *
	 * @param id Identifier of the searched natural person
	 * @return JSON {@link NaturalPersonDetailDTO} - The searched natural person.
	 */
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public NaturalPersonDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		NaturalPersonEntity naturalPersonEntity = naturalPersonService.getNaturalPerson(id);
		return modelMapper.map(naturalPersonEntity, NaturalPersonDetailDTO.class);
	}

	/**
	 * Save a new natural person with the URL information and returns it.
	 *
	 * @param naturalPersonDTO {@link NaturalPersonDTO} - natural person to be
	 *                         saved.
	 * 
	 * @return JSON {@link NaturalPersonDTO} - Saved NaturalPerson.
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public NaturalPersonDTO create(@RequestBody NaturalPersonDTO naturalPersonDTO)
			throws IllegalOperationException, EntityNotFoundException {
		NaturalPersonEntity naturalPersonEntity = naturalPersonService
				.createNaturalPerson(modelMapper.map(naturalPersonDTO, NaturalPersonEntity.class));
		return modelMapper.map(naturalPersonEntity, NaturalPersonDTO.class);
	}
}
