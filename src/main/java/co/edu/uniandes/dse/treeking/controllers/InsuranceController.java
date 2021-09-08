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

import co.edu.uniandes.dse.treeking.dto.InsuranceDTO;
import co.edu.uniandes.dse.treeking.entities.InsuranceEntity;
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

}
