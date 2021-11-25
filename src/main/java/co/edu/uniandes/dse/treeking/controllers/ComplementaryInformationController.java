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

import co.edu.uniandes.dse.treeking.dto.ActivityDTO;
import co.edu.uniandes.dse.treeking.dto.ComplementaryInformationDTO;
import co.edu.uniandes.dse.treeking.entities.ActivityEntity;
import co.edu.uniandes.dse.treeking.entities.ComplementaryInformationEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.treeking.services.ComplementaryInformationService;

@RestController
@RequestMapping("/complementaryinformations")
public class ComplementaryInformationController {

	@Autowired
	private ComplementaryInformationService complementaryinformationService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ComplementaryInformationDTO> findAll() {
		List<ComplementaryInformationEntity> complementaryinformations = complementaryinformationService
				.getComplementaryInformations();
		return modelMapper.map(complementaryinformations, new TypeToken<List<ComplementaryInformationDTO>>() {
		}.getType());
	}

	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ComplementaryInformationDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		ComplementaryInformationEntity ciEntity = complementaryinformationService.getComplementaryInformation(id);
		return modelMapper.map(ciEntity, ComplementaryInformationDTO.class);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ComplementaryInformationDTO create(@RequestBody ComplementaryInformationDTO complementaryInformationDTO) throws IllegalOperationException {
		ComplementaryInformationEntity complementaryInformationEntity = complementaryinformationService.createComplementaryInformation(modelMapper.map(complementaryInformationDTO, ComplementaryInformationEntity.class));
		return modelMapper.map(complementaryInformationEntity, ComplementaryInformationDTO.class);
	}

}
