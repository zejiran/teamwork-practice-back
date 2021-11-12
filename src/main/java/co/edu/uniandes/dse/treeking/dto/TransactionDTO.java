package co.edu.uniandes.dse.treeking.dto;

import java.util.Date;

import co.edu.uniandes.dse.treeking.enums.PaymentType;

import lombok.Data;

@Data
public class TransactionDTO {
	private Long id;
	private PaymentType payment;
	private Integer value;
	private Date creationDate;
}
