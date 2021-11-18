package co.edu.uniandes.dse.treeking.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EnterpriseDetailDTO extends EnterpriseDTO {
	private String password;
	private String mail;
	protected List<TransactionDTO> transactions;
}
