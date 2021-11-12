package co.edu.uniandes.dse.treeking.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class AdminEntity extends BaseEntity{
    private String user;
    private String password;
    private String mail;
    @OneToMany
    private List<OutingEntity> outings;
    @OneToMany
    private List<CommentEntity> replies;
}
