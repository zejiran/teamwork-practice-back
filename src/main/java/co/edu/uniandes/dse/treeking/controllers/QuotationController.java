package co.edu.uniandes.dse.treeking.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.treeking.dto.QuotationDTO;
import co.edu.uniandes.dse.treeking.dto.QuotationDetailDTO;
import co.edu.uniandes.dse.treeking.entities.QuotationEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
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
    
    /**
     * Busca el detalle de una instancia de Quotation según su identificador
     * @param id Identificador del detalle de la instancia de Quotation que se quiere buscar
     * @return Detalle de Quotation
     * @throws EntityNotFoundException
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public QuotationDetailDTO findOne (@PathVariable("id") Long id) throws EntityNotFoundException {
    	QuotationEntity quotationEntity = quotationService.getQuotation(id);
    	return modelMapper.map(quotationEntity, QuotationDetailDTO.class);
    }
}
