package co.edu.uniandes.dse.treeking.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class ReviewEntity  extends BaseEntity{
    @ElementCollection
    private List<Integer> ratings = new ArrayList<>();
    @OneToMany
    private List<CommentEntity> reviews = new ArrayList<>();

}
