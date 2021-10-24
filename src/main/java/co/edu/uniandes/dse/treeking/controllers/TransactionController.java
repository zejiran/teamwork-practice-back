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

import co.edu.uniandes.dse.treeking.dto.TransactionDTO;
import co.edu.uniandes.dse.treeking.entities.TransactionEntity;
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
}  