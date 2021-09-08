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

import co.edu.uniandes.dse.treeking.dto.QuotationDTO;
import co.edu.uniandes.dse.treeking.entities.QuotationEntity;
import co.edu.uniandes.dse.treeking.services.QuotationService;

@RestController
@RequestMapping("/quotations")
public class QuotationController {
	@Autowired
	private QuotationService quotationService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
     * Busca y devuelve todos las cotizaciones que existen en la aplicacion.
     *
     * @return JSONArray {@link QuotationDTO} - Las cotizaciones encontradas en la
     *         aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<QuotationDTO> findAll() {
            List<QuotationEntity> quotations = quotationService.getQuotations();
            return modelMapper.map(quotations, new TypeToken<List<QuotationDTO>>() {
            }.getType());
    }
}
