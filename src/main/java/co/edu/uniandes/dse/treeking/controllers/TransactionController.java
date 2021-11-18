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

import co.edu.uniandes.dse.treeking.dto.PostDetailDTO;
import co.edu.uniandes.dse.treeking.dto.TransactionDTO;
import co.edu.uniandes.dse.treeking.entities.PostEntity;
import co.edu.uniandes.dse.treeking.entities.TransactionEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.services.TransactionService;

/**
 * Clase que implementa el recurso "transactions"
 *
 */

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Busca y devuelve todas las transacciones que existen en la aplicacion.
	 *
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<TransactionDTO> findAll() {
		List<TransactionEntity> transactions = transactionService.getTransactions();
		return modelMapper.map(transactions, new TypeToken<List<TransactionDTO>>() {
		}.getType());
	}

	/**
	 * Busca el transaction con el id asociado recibido en la URL y lo devuelve.
	 *
	 * @param transactionId Identificador del transaction que se esta buscando. Este
	 *                      debe ser una cadena de dígitos.
	 * @return JSON {@link TransactionDTO} - El transaction buscado
	 */
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public TransactionDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		TransactionEntity transactionEntity = transactionService.getTransaction(id);
		return modelMapper.map(transactionEntity, TransactionDTO.class);
	}

	/**
	 * Crea un nuevo transaction con la informacion que se recibe en el cuerpo de la
	 * petición y se regresa un objeto identico con un id auto-generado por la base
	 * de datos.
	 *
	 * @param transactionDTO {@link TransactionDTO} - El transaction que se desea
	 *                       guardar.
	 * @return JSON {@link TransactionDTO} - El transaction guardado con el atributo
	 *         id autogenerado.
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public TransactionDTO create(@RequestBody TransactionDTO transactionDTO) {
		TransactionEntity transactionEntity = transactionService
				.createTransaction(modelMapper.map(transactionDTO, TransactionEntity.class));
		return modelMapper.map(transactionEntity, TransactionDTO.class);
	}

}