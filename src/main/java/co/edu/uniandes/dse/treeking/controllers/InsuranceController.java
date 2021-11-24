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

import co.edu.uniandes.dse.treeking.dto.InsuranceDTO;
import co.edu.uniandes.dse.treeking.dto.InsuranceDetailDTO;
import co.edu.uniandes.dse.treeking.entities.InsuranceEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.treeking.services.InsuranceService;

@RestController
@RequestMapping("/insurances")
public class InsuranceController {
	@Autowired
	private InsuranceService insuranceService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Busca y devuelve todos los seguros que existen en la aplicacion.
	 *
	 * @return JSONArray {@link InsuranceDTO} - Los seguros encontrados en la
	 *         aplicación. Si no hay ninguno retorna una lista vacía.
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<InsuranceDTO> findAll() {
		List<InsuranceEntity> insurances = insuranceService.getInsurances();
		return modelMapper.map(insurances, new TypeToken<List<InsuranceDTO>>() {
		}.getType());
	}

	/**
	 * Busca el detalle de una instancia de Insurance según su identificador
	 * 
	 * @param id Identificador del detalle de la instancia de Insurance que se
	 *           quiere buscar
	 * @return Detalle de Insurance
	 * @throws EntityNotFoundException
	 */
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public InsuranceDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		InsuranceEntity insuranceEntity = insuranceService.getInsurance(id);
		return modelMapper.map(insuranceEntity, InsuranceDetailDTO.class);
	}
	
	/**
	 * Crea un nuevo insurance con la informacion que se recibe en el cuerpo de la
	 * petición y se regresa un objeto identico con un id auto-generado por la base
	 * de datos.
	 *
	 * @param book {@link InsuranceDTO} - EL insurance que se desea guardar.
	 * @return JSON {@link InsuranceDTO} - El insurance guardado con el atributo id
	 *         autogenerado.
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public InsuranceDTO create(@RequestBody InsuranceDTO insuranceDTO) throws IllegalOperationException, EntityNotFoundException {
		InsuranceEntity insuranceEntity = insuranceService.createInsurance(modelMapper.map(insuranceDTO, InsuranceEntity.class));
		return modelMapper.map(insuranceEntity, InsuranceDTO.class);
	}

}
