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

import co.edu.uniandes.dse.treeking.dto.PersonDTO;
import co.edu.uniandes.dse.treeking.entities.PersonEntity;
import co.edu.uniandes.dse.treeking.services.PersonService;

/**
 * Class that implements resource "persons"
 */

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Search and return all persons that exist in the application.
	 *
	 * @return JSONArray {@link PersonDTO} - Persons find in the application. If
	 *         there are none, it returns an empty list.
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<PersonDTO> findAll() {
		List<PersonEntity> persons = personService.getPersons();
		return modelMapper.map(persons, new TypeToken<List<PersonDTO>>() {
		}.getType());
	}
}
