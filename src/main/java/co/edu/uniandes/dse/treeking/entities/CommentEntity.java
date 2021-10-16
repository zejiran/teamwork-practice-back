package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class CommentEntity extends BaseEntity{

    private String text;
    private Integer likes;
    private Integer dislikes;

    @PodamExclude
    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private List<CommentEntity> comments;

    @PodamExclude
    @ManyToOne
    @JoinColumn
    private CommentEntity comment;

}
