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

import co.edu.uniandes.dse.treeking.dto.OutingDTO;
import co.edu.uniandes.dse.treeking.dto.OutingDetailDTO;
import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.treeking.services.OutingService;

@RestController
@RequestMapping("/outings")

public class OutingController {
	@Autowired
	private OutingService outingService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Busca y devuelve todos las salidas que existen en la aplicacion.
	 *
	 * @return JSONArray {@link OutingDTO} - Las salidas encontradas en la
	 *         aplicación. Si no hay ninguno retorna una lista vacía.
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<OutingDTO> findAll() {
		List<OutingEntity> outings = outingService.getOutings();
		return modelMapper.map(outings, new TypeToken<List<OutingDTO>>() {
		}.getType());
	}

	/**
	 * Busca el detalle de una instancia de Outing según su identificador
	 * 
	 * @param id Identificador del detalle de la instancia de Outing que se quiere
	 *           buscar
	 * @return Detalle de Outing
	 * @throws EntityNotFoundException
	 */
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public OutingDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		OutingEntity outingEntity = outingService.getOuting(id);
		return modelMapper.map(outingEntity, OutingDetailDTO.class);
	}
	
	/**
	 * Crea un nuevo outing con la informacion que se recibe en el cuerpo de la
	 * petición y se regresa un objeto identico con un id auto-generado por la base
	 * de datos.
	 *
	 * @param book {@link OutingDTO} - EL outing que se desea guardar.
	 * @return JSON {@link OutingDTO} - El outing guardado con el atributo id
	 *         autogenerado.
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OutingDTO create(@RequestBody OutingDTO outingDTO) throws IllegalOperationException, EntityNotFoundException {
		OutingEntity outingEntity = outingService.createOuting(modelMapper.map(outingDTO, OutingEntity.class));
		return modelMapper.map(outingEntity, OutingDTO.class);
	}
}
