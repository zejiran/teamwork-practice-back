package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.entities.AdminEntity;
import co.edu.uniandes.dse.treeking.entities.EnterpriseEntity;
import co.edu.uniandes.dse.treeking.entities.NaturalPersonEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class CommentDetailDTO extends CommentDTO{
    private AdminEntity admin;
    private EnterpriseEntity enterprise;
    private NaturalPersonEntity naturalPerson;
    private Date date;
    private List<CommentDTO> replies;
}
