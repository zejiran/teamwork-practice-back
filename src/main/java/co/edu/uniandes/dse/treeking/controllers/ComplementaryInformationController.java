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

import co.edu.uniandes.dse.treeking.dto.ComplementaryInformationDTO;
import co.edu.uniandes.dse.treeking.entities.ComplementaryInformationEntity;
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
	public List<ComplementaryInformationDTO> findAll(){
		List<ComplementaryInformationEntity> complementaryinformations = complementaryinformationService.getComplementaryInformations();
		return modelMapper.map(complementaryinformations, new TypeToken<List<ComplementaryInformationDTO>>() {
        }.getType());
	}
	
}
