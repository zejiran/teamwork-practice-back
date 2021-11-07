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

import co.edu.uniandes.dse.treeking.dto.ClientDTO;
import co.edu.uniandes.dse.treeking.dto.ClientDetailDTO;
import co.edu.uniandes.dse.treeking.entities.ClientEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
     * Busca y devuelve todos los clientes que existen en la aplicacion.
     *
     * @return JSONArray {@link ClientDTO} - Los clientes encontrados en la
     *         aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ClientDTO> findAll() {
            List<ClientEntity> clients = clientService.getClients();
            return modelMapper.map(clients, new TypeToken<List<ClientDTO>>() {
            }.getType());
    }
    
    /**
     * Busca el detalle de una instancia de Client según su identificador
     * @param id Identificador del detalle de la instancia de Client que se quiere buscar
     * @return Detalle de Client
     * @throws EntityNotFoundException
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ClientDetailDTO findOne (@PathVariable("id") Long id) throws EntityNotFoundException {
    	ClientEntity clientEntity = clientService.getClient(id);
    	return modelMapper.map(clientEntity, ClientDetailDTO.class);
    }
}
