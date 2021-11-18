package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class TransactionDetailDTO extends TransactionDTO{
    private String userType;
    private String userID;
    private String username;
}
