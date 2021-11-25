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

import co.edu.uniandes.dse.treeking.dto.EnterpriseDTO;
import co.edu.uniandes.dse.treeking.dto.EnterpriseDetailDTO;
import co.edu.uniandes.dse.treeking.entities.EnterpriseEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.services.EnterpriseService;

/**
 * Clase que implementa el recurso "enterprises"
 *
 */

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Busca y devuelve todas las empresas que existen en la aplicacion.
	 *
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<EnterpriseDTO> findAll() {
		List<EnterpriseEntity> enterprises = enterpriseService.getEnterprises();
		return modelMapper.map(enterprises, new TypeToken<List<EnterpriseDTO>>() {
		}.getType());
	}

	/**
	 * Busca el enterprise con el id asociado recibido en la URL y lo devuelve.
	 *
	 * @param enterpriseId Identificador del enterprise que se esta buscando. Este
	 *                     debe ser una cadena de dígitos.
	 * @return JSON {@link EnterpriseDTO} - El enterprise buscado
	 */
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public EnterpriseDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		EnterpriseEntity enterpriseEntity = enterpriseService.getEnterprise(id);
		return modelMapper.map(enterpriseEntity, EnterpriseDetailDTO.class);
	}

	/**
	 * Crea un nuevo Enterprise con la informacion que se recibe en el cuerpo de la
	 * petición y se regresa un objeto identico con un id auto-generado por la base
	 * de datos.
	 *
	 * @param enterpriseDTO {@link EnterpriseDTO} - El enterprise que se desea guardar.
	 * @return JSON {@link EnterpriseDTO} - El enterprise guardado con el atributo id
	 *         autogenerado.
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EnterpriseDTO create(@RequestBody EnterpriseDTO enterpriseDTO) {
		EnterpriseEntity enterpriseEntity = enterpriseService.createEnterprise(modelMapper.map(enterpriseDTO, EnterpriseEntity.class));
		return modelMapper.map(enterpriseEntity, EnterpriseDTO.class);
	}

	
}