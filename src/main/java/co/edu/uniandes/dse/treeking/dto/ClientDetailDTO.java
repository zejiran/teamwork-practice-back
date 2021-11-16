package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClientDetailDTO extends ClientDTO {
	protected List<TransactionDTO> transactions;
}
