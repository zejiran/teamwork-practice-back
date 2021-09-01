package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Entity
@Getter
@Setter

public class ReviewEntity  extends BaseEntity{
    @ElementCollection
    private ArrayList<Integer> ratings;
    @OneToMany
    private ArrayList<CommentEntity> reviews;

}
