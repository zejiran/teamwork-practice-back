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

import co.edu.uniandes.dse.treeking.dto.NaturalPersonDTO;
import co.edu.uniandes.dse.treeking.entities.NaturalPersonEntity;
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
}