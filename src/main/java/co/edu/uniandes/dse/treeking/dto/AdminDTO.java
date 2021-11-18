package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class AdminDTO{
    private Long id;
    private String user;
    private String mail;
}
